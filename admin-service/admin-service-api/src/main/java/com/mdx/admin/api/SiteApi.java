package com.mdx.admin.api;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.pojo.dto.AdminDTO;
import com.mdx.admin.api.pojo.dto.KeywordDTO;
import com.mdx.admin.api.pojo.dto.SiteDTO;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@RequestMapping("/v1/admin/site")
public interface SiteApi {

    @ApiOperation(value = "站点site获取(10201)")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "站点ID", required = true, paramType = "query", dataType = "integer")
    })
    public ObjectResp<SiteDTO> getSite(@RequestParam("siteId") Integer siteId);


    @ApiOperation(value = "站点site存储(10202)")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<SiteDTO> createSite(@Valid @RequestBody SiteCreateReq req);

    @ApiOperation(value = "站点site列表(10203)")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "accessToken", required = true, dataType = "string", paramType = "header"),
//            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
//            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<List<SiteDTO>> listSite();



    @ApiOperation(value = "站点site删除(10204)")
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header")
    })
    public ObjectResp<Integer> deleteSite(@Valid @RequestBody SiteDeleteReq req);

}
