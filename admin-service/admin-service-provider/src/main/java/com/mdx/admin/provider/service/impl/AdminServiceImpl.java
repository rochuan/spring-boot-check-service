package com.mdx.admin.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.mdx.admin.api.ConfigApi;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.*;
import com.mdx.admin.api.utils.EncryptUtil;
import com.mdx.admin.provider.dao.*;
import com.mdx.admin.provider.service.AdminService;
import com.mdx.admin.api.error.ErrorCode;
import com.mdx.common.IdWorker;
import com.mdx.common.ObjectResp;
import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private KeywordDAO keywordDAO;
    @Autowired
    private SiteDAO siteDAO;
    @Autowired
    private ConfigDAO configDAO;
    @Autowired
    private CustomCheckDAO customCheckDAO;
    @Autowired
    private SiteUrlDAO siteUrlDAO;
    @Autowired
    private SiteCheckTaskLogDAO siteCheckTaskLogDAO;
    @Autowired
    private TaskRecordDAO taskRecordDAO;
    @Autowired
    private AdminDAO adminDAO;


    @Override
    public ObjectResp<AccessTokenDTO> login(AdminLoginReq req) {
        AdminDTO adminDTO = adminDAO.getAdminByAccount(req.getAccount());
        if (null == adminDTO) {
            return new ObjectResp(ErrorCode.EMPTY_USER);
        }
        EncryptUtil encrypt = new EncryptUtil();
        String password = encrypt.SHA512(encrypt.MD5(req.getPassword()) + adminDTO.getSalt());

        if (!(password.equals(adminDTO.getPassword()))) {
            return new ObjectResp(ErrorCode.PASSWORD_ERROR);
        }

        String acccessToken = encrypt.SHA256(encrypt.MD5(req.getAccount()) + adminDTO.getSalt() + System.currentTimeMillis());

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setExpireIn(7200L);
        accessTokenDTO.setAccessToken(acccessToken);
        accessTokenDTO.setUserInfo(adminDTO);

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.select(2);

        jedis.set(acccessToken, Long.toString(adminDTO.getAdminId()));
        jedis.expire(acccessToken, 7200);

        String key = "silk_check_access_token_" + Long.toString(adminDTO.getAdminId());
        jedis.set(key, acccessToken);
        jedis.expire(key, 7200);

        return new ObjectResp<AccessTokenDTO>(accessTokenDTO);
    }

    @Override
    public ObjectResp<AdminDTO> getAdmin(Long adminId) {

        AdminDTO adminDTO = adminDAO.getAdmin(adminId);
        return new ObjectResp<AdminDTO>(adminDTO);
    }

    @Override
    public ObjectResp logout(Long adminId) {

        String key = "silk_check_access_token_" + Long.toString(adminId);

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.select(2);

        String accessToken = jedis.get(key);
        jedis.del(accessToken);
        jedis.del(key);
        return new ObjectResp<>(ErrorCode.SUCCESS);
    }

    @Override
    public ObjectResp<PageInfo<AdminDTO>> listAdmin(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<AdminDTO> adminDTOList = adminDAO.listAdmin(pageNumber, pageSize);
        if (null == adminDTOList) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        PageInfo<AdminDTO> pageInfo = new PageInfo<AdminDTO>(adminDTOList);
        return new ObjectResp<PageInfo<AdminDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<SiteDTO> createSite(SiteCreateReq req) {
        SiteDTO siteDTO = siteDAO.selectByPrimaryName(req.getSiteName());
        if (null == siteDTO) {
            siteDTO = new SiteDTO();
            siteDTO.setSiteName(req.getSiteName());
            siteDTO.setAllowDomains(req.getAllow_domains());
            siteDTO.setStartUrls(req.getStart_urls());
            siteDTO.setCode(req.getCode());

            int last_insert_id = siteDAO.insert(siteDTO);
            return new ObjectResp<SiteDTO>(siteDTO);
        }
        return new ObjectResp<>(ErrorCode.DATA_INFO_EXIST);
    }

    @Override
    public ObjectResp<SiteDTO> getSite(Integer siteId) {
        SiteDTO siteDTO = siteDAO.selectByPrimaryKey(siteId);
        if (null == siteDTO) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        return new ObjectResp<SiteDTO>(siteDTO);
    }

    @Override
    public ObjectResp<List<SiteDTO>> listSite(int pageNumber, int pageSize) {
        List<SiteDTO> siteDTOList = siteDAO.listSite();
        if (null == siteDTOList) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        return new ObjectResp<List<SiteDTO>>(siteDTOList);
    }

    @Override
    public ObjectResp<Integer> deleteSite(SiteDeleteReq req) {
        Integer flag = siteDAO.deleteByPrimaryKey(req.getSiteId());
        if (flag <= 0) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_DELETE_ERROR);
        }
        return new ObjectResp<Integer>(flag);
    }


    @Override
    public ObjectResp<KeywordDTO> createKeyword(KeywordCreateReq req) {

        KeywordDTO keywordDTO = keywordDAO.selectByPrimaryKeyword(req.getKeywordText());
        if (null == keywordDTO) {
            keywordDTO = new KeywordDTO();
            keywordDTO.setKeywordText(req.getKeywordText());
            Integer keywordId = keywordDAO.insert(keywordDTO);
            return new ObjectResp<KeywordDTO>(keywordDTO);
        }
        return new ObjectResp<>(ErrorCode.DATA_INFO_EXIST);

    }

    @Override
    public ObjectResp<KeywordDTO> getKeyword(Integer keywordId) {
        KeywordDTO keywordDTO = keywordDAO.selectByPrimaryKey(keywordId);
        if (null == keywordDTO) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        return new ObjectResp<KeywordDTO>(keywordDTO);
    }

    @Override
    public ObjectResp<PageInfo<KeywordDTO>> listKeyword(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<KeywordDTO> keywordDTOList = keywordDAO.listKeyword(pageNumber, pageSize);
        if (null == keywordDTOList) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        PageInfo<KeywordDTO> pageInfo = new PageInfo<KeywordDTO>(keywordDTOList);
        return new ObjectResp<PageInfo<KeywordDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<Integer> deleteKeyword(KeywordDeleteReq req) {
        Integer keyword = keywordDAO.deleteByPrimaryKey(req.getKeywordId());
        if (keyword <= 0) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_DELETE_ERROR);
        }
        return new ObjectResp<Integer>(keyword);
    }

    @Override
    public ObjectResp<SmsConfigDTO> getSmsConfig() {

        SmsConfigDTO smsConfigDTO = new SmsConfigDTO();

        List<ConfigDTO> configDTOS = configDAO.selectSmsEmailConfigList();
        if (null == configDTOS) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        for (ConfigDTO configDTO : configDTOS) {
            if (null != configDTO) {
                if ("sms_key".equals(configDTO.getConfigKey())) {
                    smsConfigDTO.setSmsConfigKey(configDTO.getConfigValue());
                }
                if ("sms_secret".equals(configDTO.getConfigKey())) {
                    smsConfigDTO.setSmsConfigSecret(configDTO.getConfigValue());
                }
                if ("sms_sign".equals(configDTO.getConfigKey())) {
                    smsConfigDTO.setSmsConfigSign(configDTO.getConfigValue());
                }
                if ("sms_template_id".equals(configDTO.getConfigKey())) {
                    smsConfigDTO.setSmsConfigTemplateId(configDTO.getConfigValue());
                }
            }
        }
        return new ObjectResp<SmsConfigDTO>(smsConfigDTO);
    }

    @Override
    public ObjectResp<EmailConfigDTO> getEmailConfig() {

        EmailConfigDTO emailConfigDTO = new EmailConfigDTO();

        List<ConfigDTO> configDTOS = configDAO.selectSmsEmailConfigList();
        if (null == configDTOS) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        for (ConfigDTO configDTO : configDTOS) {
            if (null != configDTO) {
                if ("email_server".equals(configDTO.getConfigKey())) {
                    emailConfigDTO.setEmailServer(configDTO.getConfigValue());
                }
                if ("email_port".equals(configDTO.getConfigKey())) {
                    emailConfigDTO.setEmailPort(configDTO.getConfigValue());
                }
                if ("email_user".equals(configDTO.getConfigKey())) {
                    emailConfigDTO.setEmailUser(configDTO.getConfigValue());
                }
                if ("email_password".equals(configDTO.getConfigKey())) {
                    emailConfigDTO.setEmailPassword(configDTO.getConfigValue());
                }
            }
        }
        return new ObjectResp<EmailConfigDTO>(emailConfigDTO);
    }

    @Override
    public ObjectResp<Integer> saveSmsConfig(SaveSmsConfigReq req) {

        Integer flag;
        flag = 1;
        configDAO.updateKVConfigSelective("sms_key", req.getSmsConfigKey());
        configDAO.updateKVConfigSelective("sms_secret", req.getSmsConfigSecret());
        configDAO.updateKVConfigSelective("sms_sign", req.getSmsConfigSign());
        configDAO.updateKVConfigSelective("sms_template_id", req.getSmsConfigTemplateId());

        return new ObjectResp<Integer>(flag);

    }

    @Override
    public ObjectResp<Integer> saveEmailConfig(SaveEmailConfigReq req) {
        Integer flag = 1;
        configDAO.updateKVConfigSelective("email_server", req.getEmailServer());
        configDAO.updateKVConfigSelective("email_port", req.getEmailPort());
        configDAO.updateKVConfigSelective("email_user", req.getEmailUser());
        configDAO.updateKVConfigSelective("email_password", req.getEmailPassword());

        return new ObjectResp<Integer>(flag);
    }

    @Override
    public ObjectResp<RiskNoticeConfigDTO> getRiskNotice() {

        RiskNoticeConfigDTO riskNoticeConfigDTO = new RiskNoticeConfigDTO();
        List<String> mobiles = getRiskNoticeMobiles();
        List<String> emails = getRiskNoticeEmails();

        riskNoticeConfigDTO.setEmails(emails);
        riskNoticeConfigDTO.setMobiles(mobiles);

        return new ObjectResp<RiskNoticeConfigDTO>(riskNoticeConfigDTO);

    }

    @Override
    public ObjectResp<Integer> saveRiskNotice(SaveRiskNoticeConfigReq req) {
        Integer flag = 1;
        String risk_notice_mobiles = String.join(",", req.getMobiles());
        String risk_notice_emails = String.join(",", req.getEmails());
        configDAO.updateKVConfigSelective("risk_notice_mobiles", risk_notice_mobiles);
        configDAO.updateKVConfigSelective("risk_notice_emails", risk_notice_emails);

        return new ObjectResp<Integer>(flag);
    }

    @Override
    public ObjectResp<MonitorReportNoticeConfigDTO> getMonitorReportNotice() {
        List<String> emails = new ArrayList<String>();
        MonitorReportNoticeConfigDTO monitorReportNoticeConfigDTO = new MonitorReportNoticeConfigDTO();
        String monitorReportNoticeEmailsStr = "monitor_report_notice_emails";
        ConfigDTO configDTO = configDAO.selectConfigByConfigKey(monitorReportNoticeEmailsStr);
        if (null == configDTO) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        String[] riskNoticeMobiles = configDTO.getConfigValue().split(",");
        if (riskNoticeMobiles.length <= 0) {
            return new ObjectResp<MonitorReportNoticeConfigDTO>(monitorReportNoticeConfigDTO);
        }
        for (String mobile : riskNoticeMobiles) {
            emails.add(mobile);
        }
        monitorReportNoticeConfigDTO.setEmails(emails);
        return new ObjectResp<MonitorReportNoticeConfigDTO>(monitorReportNoticeConfigDTO);
    }

    @Override
    public ObjectResp<Integer> saveMonitorReportNotice(SaveMonitorReportNoticeConfigReq req) {
        Integer flag = 1;
        String risk_notice_emails = String.join(",", req.getEmails());
        configDAO.updateKVConfigSelective("monitor_report_notice_emails", risk_notice_emails);

        return new ObjectResp<Integer>(flag);
    }

    @Override
    public ObjectResp<CustomCheckDTO> createCustomCheck(CustomCheckCreateReq req) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        IdWorker idWorker = new IdWorker(0, 0);

        String reportId = sdf.format(date) + Long.toString(idWorker.nextId());

        CustomCheckDTO customCheckDTO = new CustomCheckDTO();
        customCheckDTO.setReportId(reportId);
        customCheckDTO.setUrlType(req.getUrlType());
        customCheckDTO.setSiteId(req.getSiteId());
        customCheckDTO.setStatus(0);
        customCheckDTO.setGmtCreated(date);


        Integer lastId = customCheckDAO.insert(customCheckDTO);
        if (lastId <= 0) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_CREATE_ERROR);
        }
        //插入自定义数据
        SiteUrlDTO siteUrlDTO = new SiteUrlDTO();

        if ((4 == req.getUrlType()) && (req.getContent().size() > 0)) {
            siteUrlDTO.setSiteId(req.getSiteId());
            siteUrlDTO.setUrlType(req.getUrlType());
            siteUrlDTO.setReportId(reportId);
            siteUrlDTO.setCheckType(0);
            siteUrlDTO.setGmtCreated(date);
            for (String url : req.getContent()) {
                siteUrlDTO.setUrl(url);
                // 0, html, 1 image
                Boolean image = isImage(url);
                if (true == image) {
                    siteUrlDTO.setUrlContentType(1);
                } else {
                    siteUrlDTO.setUrlContentType(0);
                }
                siteUrlDAO.insert(siteUrlDTO);
            }
        }
        //执行成功 执行shell
        try {
            String code = "";
            SiteDTO siteDTO = siteDAO.selectByPrimaryKey(req.getSiteId());
            if (null != siteDTO) {
                code = siteDTO.getCode();
            }
            execCustomBashCommand(reportId, code , req.getUrlType());
        } catch (Exception e) {
            System.out.printf("e:" + e.getStackTrace());
        }

        return new ObjectResp<CustomCheckDTO>(customCheckDTO);
    }

    private void execCustomBashCommand(String reportId, String code , int reportType) throws Exception {
        String bashCommand = "sh /var/www/websites/aliyun/aliyun/custom_check_cron.sh " + code + " " + reportId + " " + reportType;
        System.out.println(bashCommand);
        Runtime runtime = Runtime.getRuntime();
        Process pro = runtime.exec(bashCommand);
        int status = pro.waitFor();
        if (status != 0) {
            System.out.println(reportId + "Failed to call shell's command ");
        } else {
            System.out.println(reportId + "Success to call shell's command ");
        }
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> listRiskLog(int siteId, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.listRiskLog(siteId, pageNumber, pageSize);
        if (null == siteCheckTaskLogDTOS) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        return new ObjectResp<PageInfo<SiteCheckTaskLogDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<DashboardDTO> getDashboard(int siteId, int pageNumber, int pageSize) {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setHomepageDTO(getHomepageCheck(siteId));
        dashboardDTO.setImpotantDTO(getImpotantCheck(siteId));
        dashboardDTO.setCustomDTO(getCustomDTOCheck(siteId));
        dashboardDTO.setAllPageDTO(getAllPageCheck(siteId));

        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.listRiskLog(siteId, pageNumber, pageSize);
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        dashboardDTO.setSiteCheckTaskLogDTO(pageInfo);
        return new ObjectResp<DashboardDTO>(dashboardDTO);
    }


    @Override
    public ObjectResp<CheckReportDTO> getReport(int siteId, String reportId, int reportType) {
        CheckReportDTO checkReportDTO = new CheckReportDTO();
        TaskRecordDTO taskRecordDTO = new TaskRecordDTO();

        SiteDTO siteDTO = siteDAO.selectByPrimaryKey(siteId);
        checkReportDTO.setSiteDTO(siteDTO);

        switch (reportType) {
            case 0:
                taskRecordDTO = getHomepageCheck(siteId);
                break;
            case 1:
                taskRecordDTO = getImpotantCheck(siteId);
                break;
            case 4:
                taskRecordDTO = getCustomDTOCheck(siteId);
                break;
            default:
                taskRecordDTO = getAllPageCheck(siteId);

        }
        checkReportDTO.setTaskRecordDTO(taskRecordDTO);
        checkReportDTO.setRiskReportListDTO(getRiskReportList(siteId, reportId, reportType, 1, 20, true));
        checkReportDTO.setCheckReportListDTO(getCheckReportList(siteId, reportId, reportType, 1, 20, true));
        return new ObjectResp<CheckReportDTO>(checkReportDTO);
    }


    public PageInfo<SiteCheckTaskLogDTO> getRiskReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize, Boolean falg) {
        //根据t_d_task_record表中reportID获取 ID
        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.getRiskReportList(siteId, reportId, pageNumber, pageSize);
        //根据ID查询有风险的页面
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        return pageInfo;
    }

    public PageInfo<SiteCheckTaskLogDTO> getCheckReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize, Boolean falg) {
        //根据t_d_task_record表中reportID获取 ID
        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.getCheckReportList(siteId, reportId, pageNumber, pageSize);
        //根据ID查询有风险的页面
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        return pageInfo;
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getRiskReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize) {
        //根据t_d_task_record表中reportID获取 ID
        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.getRiskReportList(siteId, reportId, pageNumber, pageSize);
        //根据ID查询有风险的页面
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        return new ObjectResp<PageInfo<SiteCheckTaskLogDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getCheckReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize) {
        //根据t_d_task_record表中reportID获取 ID
        PageHelper.startPage(pageNumber, pageSize);
        List<SiteCheckTaskLogDTO> siteCheckTaskLogDTOS = siteCheckTaskLogDAO.getCheckReportList(siteId, reportId, pageNumber, pageSize);
        //根据ID查询有风险的页面
        PageInfo<SiteCheckTaskLogDTO> pageInfo = new PageInfo<SiteCheckTaskLogDTO>(siteCheckTaskLogDTOS);
        return new ObjectResp<PageInfo<SiteCheckTaskLogDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<CountCheckDTO> getCheckCount(int siteId) {
        CountCheckDTO countCheckDTO = new CountCheckDTO();
        Integer countHomepage = siteUrlDAO.countHomepage(siteId);
        Integer countImpotant = siteUrlDAO.countImpotant(siteId);
        Integer countAllPage = siteUrlDAO.countAllPage(siteId);

        countCheckDTO.setHomepageCount(countHomepage);
        countCheckDTO.setAllPageCount(countAllPage);
        countCheckDTO.setImpotantCount(countImpotant);
        return new ObjectResp<CountCheckDTO>(countCheckDTO);
    }

    @Override
    public ObjectResp<Integer> sendReportEmail(ReportEmailCreateReq req) {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        ObjectResp<EmailConfigDTO> emailConfigDTOObjectResp = getEmailConfig();
        if (null == emailConfigDTOObjectResp.getData()) {
            return new ObjectResp<Integer>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        EmailConfigDTO emailConfigDTO = emailConfigDTOObjectResp.getData();
        javaMailSender.setHost(emailConfigDTO.getEmailServer());
        javaMailSender.setPort(Integer.getInteger(emailConfigDTO.getEmailPort()));
        javaMailSender.setUsername(emailConfigDTO.getEmailUser());
        javaMailSender.setPassword(emailConfigDTO.getEmailPassword());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfigDTO.getEmailServer());
        message.setTo("1990230068@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        javaMailSender.send(message);

        return new ObjectResp<Integer>(ErrorCode.SUCCESS);

    }

    private TaskRecordDTO getHomepageCheck(int siteId) {
        Integer reportType = 0;
        TaskRecordDTO taskRecordDTO = taskRecordDAO.selectBySiteId(siteId, reportType);
        return taskRecordDTO;
    }

    private TaskRecordDTO getImpotantCheck(int siteId) {
        Integer reportType = 1;
        TaskRecordDTO taskRecordDTO = taskRecordDAO.selectBySiteId(siteId, reportType);
        return taskRecordDTO;
    }

    private TaskRecordDTO getAllPageCheck(int siteId) {
        TaskRecordDTO taskRecordDTO = taskRecordDAO.selectAllPage(siteId);
        return taskRecordDTO;
    }

    private TaskRecordDTO getCustomDTOCheck(int siteId) {
        Integer reportType = 4;
        TaskRecordDTO taskRecordDTO = taskRecordDAO.selectBySiteId(siteId, reportType);
        return taskRecordDTO;
    }

    @Override
    public ObjectResp<SiteUrlDTO> createSiteUrlImportant(SiteUrlImportantCreateReq req) {
        SiteUrlDTO siteUrlDTO = new SiteUrlDTO();
        if (req.getUrls().size() > 0) {
            siteUrlDTO.setSiteId(req.getSiteId());
            siteUrlDTO.setUrlType(req.getUrlType());
            siteUrlDTO.setCheckType(0);
            siteUrlDTO.setGmtCreated(new Date());
            for (String url : req.getUrls()) {
                siteUrlDTO.setUrl(url);
                // 0, html, 1 image
                Boolean image = isImage(url);
                if (true == image) {
                    siteUrlDTO.setUrlContentType(1);
                } else {
                    siteUrlDTO.setUrlContentType(0);
                }
                siteUrlDAO.insert(siteUrlDTO);
            }
        }
        return new ObjectResp<SiteUrlDTO>(siteUrlDTO);
    }

    @Override
    public ObjectResp<PageInfo<SiteUrlDTO>> listSiteUrlImportant(int siteId, int pageNumber, int pageSize) {

        PageHelper.startPage(pageNumber, pageSize);
        List<SiteUrlDTO> siteUrlDTOS = siteUrlDAO.listSiteUrlImportant(siteId, pageNumber, pageSize);
        if (null == siteUrlDTOS) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_NOT_EXIST);
        }
        PageInfo<SiteUrlDTO> pageInfo = new PageInfo<SiteUrlDTO>(siteUrlDTOS);
        return new ObjectResp<PageInfo<SiteUrlDTO>>(pageInfo);
    }

    @Override
    public ObjectResp<Integer> deleteSiteUrlImportant(SiteUrlDeleteReq req) {
        Integer flag = siteUrlDAO.deleteByPrimaryKey(req.getSiteUrlId());
        if (flag <= 0) {
            return new ObjectResp<>(ErrorCode.DATA_INFO_DELETE_ERROR);
        }
        return new ObjectResp<Integer>(flag);
    }

    /**
     * 判断URL是否为图片
     *
     * @param url
     * @return
     */
    private Boolean isImage(String url) {

        String[] allowTypes = new String[]{".bmp", ".png", "gif", ".jpg", ".jpeg"};
        if (null == url || "".equals(url)) {
            return false;
        }
        for (String type : allowTypes) {
            if (url.indexOf(type) > -1) {
                return true;
            }
        }
        return false;
    }

    public List<String> getRiskNoticeMobiles() {
        List<String> mobiles = new ArrayList<String>();
        String riskNoticeMobile = "risk_notice_mobiles";
        ConfigDTO configDTO = configDAO.selectConfigByConfigKey(riskNoticeMobile);
        if (null == configDTO) {
            return null;
        }
        String[] riskNoticeMobiles = configDTO.getConfigValue().split(",");
        if (riskNoticeMobiles.length <= 0) {
            return mobiles;
        }
        for (String mobile : riskNoticeMobiles) {
            mobiles.add(mobile);
        }
        return mobiles;
    }

    public List<String> getRiskNoticeEmails() {
        List<String> emails = new ArrayList<String>();
        String riskNoticeEmailsStr = "risk_notice_emails";
        ConfigDTO configDTO = configDAO.selectConfigByConfigKey(riskNoticeEmailsStr);
        if (null == configDTO) {
            return null;
        }
        String[] riskNoticeEmails = configDTO.getConfigValue().split(",");
        if (riskNoticeEmails.length <= 0) {
            return emails;
        }
        for (String email : riskNoticeEmails) {
            emails.add(email);
        }
        return emails;
    }
}
