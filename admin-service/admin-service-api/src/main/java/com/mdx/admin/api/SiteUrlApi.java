package com.mdx.admin.api;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.SiteDTO;
import com.mdx.admin.api.pojo.dto.SiteUrlDTO;
import com.mdx.admin.api.req.SiteUrlDeleteReq;
import com.mdx.admin.api.req.SiteUrlImportantCreateReq;
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
import java.util.List;

@ApiIgnore
@RequestMapping("/v1/admin/siteUrl/important")
public interface SiteUrlApi {

    @ApiOperation(value = "重点页面存储(10500)")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<SiteUrlDTO> createSiteUrlImportant(@Valid @RequestBody SiteUrlImportantCreateReq req);

    @ApiOperation(value = "重点页面列表(10201)")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "siteId", value = "siteId",defaultValue = "1", required = true, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<PageInfo<SiteUrlDTO>> listSiteUrlImportant(@RequestParam(value = "siteId" , required = false) int siteId , @RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);


    @ApiOperation(value = "重点页面删除(10202)")
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header")
    })
    public ObjectResp<Integer> deleteSiteUrlImportant(@Valid @RequestBody SiteUrlDeleteReq req);
    
}
