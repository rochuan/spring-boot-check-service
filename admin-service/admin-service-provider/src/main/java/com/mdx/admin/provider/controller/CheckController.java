package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.CheckApi;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.ChecktaskLogDeleteReq;
import com.mdx.admin.api.req.CustomCheckCreateReq;
import com.mdx.admin.api.req.ReportEmailCreateReq;
import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.service.IAdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "管理员系统检测接口")
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
public class CheckController implements CheckApi {

    @Autowired
    private IAdminService adminService;


    @Override

    public ObjectResp<DashboardDTO> getDashboard(int siteId , int pageNumber, int pageSize) {
        return adminService.getDashboard(siteId , pageNumber , pageSize);
    }

    @Override
    public ObjectResp<CustomCheckDTO> createCustom(@Valid @RequestBody CustomCheckCreateReq req) {
        ObjectResp<CustomCheckDTO> customCheckDTOObjectResp = adminService.createCustomCheck(req);

        return customCheckDTOObjectResp;
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> listRiskLog(int siteId, int pageNumber, int pageSize) {
        return adminService.listRiskLog(siteId, pageNumber, pageSize);
    }

    @Override
    public ObjectResp<CheckReportDTO> getReport(int siteId, String reportId, int reportType) {
        return adminService.getReport(siteId , reportId , reportType );
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getRiskReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize) {
        return adminService.getRiskReportList(siteId , reportId , reportType , pageNumber , pageSize);
    }

    @Override
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getCheckReportList(int siteId, String reportId, int reportType, int pageNumber, int pageSize) {
        return adminService.getCheckReportList(siteId , reportId , reportType , pageNumber , pageSize);
    }

    @Override
    @Auth
    public ObjectResp<Integer> sendReportEmail(@Valid @RequestBody ReportEmailCreateReq req) {
        return adminService.sendReportEmail(req);
    }

    @Override
    public ObjectResp<CountCheckDTO> getCheckCount(int siteId) {
        return adminService.getCheckCount(siteId);
    }

    @Override
    public ObjectResp<Integer> deleteSiteCheckTaskLogUrl(@Valid @RequestBody ChecktaskLogDeleteReq req) {
        return null;
    }


}
