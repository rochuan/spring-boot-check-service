package com.mdx.admin.provider.controller;

import com.mdx.admin.api.ConfigApi;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.*;
import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.service.IAdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "管理员系统配置接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-24
 */
@Auth
public class ConfigController implements ConfigApi {

    @Autowired
    private IAdminService adminService;

    @Override
    public ObjectResp<SmsConfigDTO> getSmsConfig() {
        ObjectResp<SmsConfigDTO> objectResp = adminService.getSmsConfig();
        return objectResp;
    }

    @Override
    public ObjectResp<EmailConfigDTO> getEmailConfig() {
        ObjectResp<EmailConfigDTO> objectResp = adminService.getEmailConfig();
        return objectResp;
    }

    @Override
    public ObjectResp<Integer> saveSmsConfig(@Valid @RequestBody SaveSmsConfigReq req) {
        ObjectResp<Integer> objectResp = adminService.saveSmsConfig(req);
        return objectResp;
    }

    @Override
    public ObjectResp<Integer> saveEmailConfig(@Valid @RequestBody SaveEmailConfigReq req) {
        ObjectResp<Integer> objectResp = adminService.saveEmailConfig(req);
        return objectResp;
    }

    @Override
    public ObjectResp<RiskNoticeConfigDTO> getRiskNotice() {
        ObjectResp<RiskNoticeConfigDTO> objectResp = adminService.getRiskNotice();
        return objectResp;
    }

    @Override
    public ObjectResp<Integer> saveRiskNotice(@Valid @RequestBody  SaveRiskNoticeConfigReq req) {
        ObjectResp<Integer> objectResp = adminService.saveRiskNotice(req);
        return objectResp;
    }

    @Override
    public ObjectResp<MonitorReportNoticeConfigDTO> getMonitorReportNotice() {
        ObjectResp<MonitorReportNoticeConfigDTO> objectResp = adminService.getMonitorReportNotice();
        return objectResp;
    }

    @Override
    public ObjectResp<Integer> saveMonitorReportNotice(@Valid @RequestBody SaveMonitorReportNoticeConfigReq req) {
        ObjectResp<Integer> objectResp = adminService.saveMonitorReportNotice(req);
        return objectResp;
    }
}
