package com.mdx.admin.provider.service;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.*;
import com.mdx.common.ObjectResp;

import java.util.List;


/**
 * 管理员服务
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */
public interface AdminService {

    ObjectResp<AccessTokenDTO> login(AdminLoginReq req);

    ObjectResp<AdminDTO> getAdmin(Long userId);

    ObjectResp logout(Long userId);

    ObjectResp<PageInfo<AdminDTO>> listAdmin(int pageNumber, int pageSize);


    //站点
    ObjectResp<SiteDTO> createSite(SiteCreateReq req);

    ObjectResp<SiteDTO> getSite(Integer siteId);

    ObjectResp<List<SiteDTO>> listSite(int pageNumber, int pageSize);

    ObjectResp<Integer> deleteSite(SiteDeleteReq req);

    ObjectResp<KeywordDTO> createKeyword(KeywordCreateReq req);

    ObjectResp<KeywordDTO> getKeyword(Integer keywordId);

    ObjectResp<PageInfo<KeywordDTO>> listKeyword(int pageNumber, int pageSize);

    ObjectResp<Integer> deleteKeyword(KeywordDeleteReq req);


    //配置
    ObjectResp<SmsConfigDTO> getSmsConfig();

    ObjectResp<EmailConfigDTO> getEmailConfig();

    ObjectResp<Integer> saveSmsConfig(SaveSmsConfigReq req);

    ObjectResp<Integer> saveEmailConfig(SaveEmailConfigReq req);

    ObjectResp<RiskNoticeConfigDTO> getRiskNotice();

    ObjectResp<Integer> saveRiskNotice(SaveRiskNoticeConfigReq req);

    ObjectResp<MonitorReportNoticeConfigDTO> getMonitorReportNotice();

    ObjectResp<Integer> saveMonitorReportNotice(SaveMonitorReportNoticeConfigReq req);

    //检测
    ObjectResp<CustomCheckDTO> createCustomCheck(CustomCheckCreateReq req);

    ObjectResp<PageInfo<SiteCheckTaskLogDTO>> listRiskLog(int siteId , int pageNumber, int pageSize);

    ObjectResp<DashboardDTO> getDashboard(int siteId , int pageNumber, int pageSize);

    ObjectResp<CheckReportDTO> getReport(int siteId, String reportId, int reportType);

    ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getRiskReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize);

    ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getCheckReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize);

    ObjectResp<CountCheckDTO> getCheckCount(int siteId);

    ObjectResp<Integer> sendReportEmail(ReportEmailCreateReq req);
    //重点页面
    ObjectResp<SiteUrlDTO> createSiteUrlImportant(SiteUrlImportantCreateReq req);

    ObjectResp<PageInfo<SiteUrlDTO>> listSiteUrlImportant(int siteId, int pageNumber, int pageSize);

    ObjectResp<Integer> deleteSiteUrlImportant(SiteUrlDeleteReq req);


}
