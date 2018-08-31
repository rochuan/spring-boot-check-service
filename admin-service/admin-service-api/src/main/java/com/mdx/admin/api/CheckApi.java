package com.mdx.admin.api;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.*;
import com.mdx.admin.api.req.CustomCheckCreateReq;
import com.mdx.admin.api.req.ReportEmailCreateReq;
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
@RequestMapping("/v1/admin/check")
public interface CheckApi {

    @ApiOperation(value = "获取Dashboard检测(10600)")
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<DashboardDTO> getDashboard(@RequestParam(value = "siteId" , required = true) int siteId ,@RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);



    @ApiOperation(value = "人工检测(10601)")
    @RequestMapping(method = RequestMethod.POST, value = "/custom")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<CustomCheckDTO> createCustom(@Valid @RequestBody CustomCheckCreateReq req);



    @ApiOperation(value = "获取检测风险记录列表(10602)")
    @RequestMapping(method = RequestMethod.GET, value = "/risk/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> listRiskLog(@RequestParam(value = "siteId" , required = true) int siteId , @RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);



    @ApiOperation(value = "获取检测报告(10603)")
    @RequestMapping(method = RequestMethod.GET, value = "/report")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "reportId", value = "reportId",defaultValue = "1", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "reportType", value = "reportType",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
    })
    public ObjectResp<CheckReportDTO> getReport(@RequestParam(value = "siteId" , required = true) int siteId , @RequestParam(value = "reportId" , required = true) String reportId ,@RequestParam(value = "reportType" , required = true) int reportType );


    @ApiOperation(value = "获取风险报告列表(10604)")
    @RequestMapping(method = RequestMethod.GET, value = "/report/listRiskReport")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "reportId", value = "reportId",defaultValue = "1", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "reportType", value = "reportType",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer"),
    })
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getRiskReportList(@RequestParam(value = "siteId" , required = true) int siteId , @RequestParam(value = "reportId" , required = true) String reportId ,@RequestParam(value = "reportType" , required = true) int reportType , @RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);


    @ApiOperation(value = "获取检测网址报告列表(10605)")
    @RequestMapping(method = RequestMethod.GET, value = "/report/listCheckReport")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "reportId", value = "reportId",defaultValue = "1", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "reportType", value = "reportType",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer"),
    })
    public ObjectResp<PageInfo<SiteCheckTaskLogDTO>> getCheckReportList(@RequestParam(value = "siteId" , required = true) int siteId , @RequestParam(value = "reportId" , required = true) String reportId ,@RequestParam(value = "reportType" , required = true) int reportType , @RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);


    @ApiOperation(value = "获取检测报告(10606)")
    @RequestMapping(method = RequestMethod.POST, value = "/sendReportEmail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<Integer> sendReportEmail(@Valid @RequestBody ReportEmailCreateReq req);


    @ApiOperation(value = "获取检测统计(10607)")
    @RequestMapping(method = RequestMethod.GET, value = "/countCheck")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
    })
    public ObjectResp<CountCheckDTO> getCheckCount(@RequestParam(value = "siteId" , required = true) int siteId );



}
