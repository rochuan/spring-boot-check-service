package com.mdx.admin.api;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.*;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@ApiIgnore
@RequestMapping("/v1/admin/config")
public interface ConfigApi {


    @ApiOperation(value = "系统短信配置获取(10301)")
    @RequestMapping(method = RequestMethod.GET, value = "/sms")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<SmsConfigDTO> getSmsConfig();


    @ApiOperation(value = "系统邮件配置获取(10302)")
    @RequestMapping(method = RequestMethod.GET, value = "/email")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<EmailConfigDTO> getEmailConfig();

    @ApiOperation(value = "系统短信配置保存(10303)")
    @RequestMapping(method = RequestMethod.POST, value = "/saveSms")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<Integer> saveSmsConfig(@Valid @RequestBody SaveSmsConfigReq req);


    @ApiOperation(value = "系统邮件配置保存(10304)")
    @RequestMapping(method = RequestMethod.POST, value = "/saveEmail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<Integer> saveEmailConfig(@Valid @RequestBody SaveEmailConfigReq req);


    @ApiOperation(value = "系统风险通知配置获取(10305)")
    @RequestMapping(method = RequestMethod.GET, value = "/riskNotice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<RiskNoticeConfigDTO> getRiskNotice();


    @ApiOperation(value = "系统风险通知配置保存(10306)")
    @RequestMapping(method = RequestMethod.POST, value = "/saveRiskNotice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<Integer> saveRiskNotice(@Valid @RequestBody SaveRiskNoticeConfigReq req);

    @ApiOperation(value = "监测报告通知配置获取(10307)")
    @RequestMapping(method = RequestMethod.GET, value = "/monitorReportNotice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<MonitorReportNoticeConfigDTO> getMonitorReportNotice();


    @ApiOperation(value = "监测报告通知配置保存(10308)")
    @RequestMapping(method = RequestMethod.POST, value = "/saveMonitorReportNotice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<Integer> saveMonitorReportNotice(@Valid @RequestBody SaveMonitorReportNoticeConfigReq req);
}
