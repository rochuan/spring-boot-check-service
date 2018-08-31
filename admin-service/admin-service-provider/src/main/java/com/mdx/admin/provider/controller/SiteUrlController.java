package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.SiteApi;
import com.mdx.admin.api.SiteUrlApi;
import com.mdx.admin.api.pojo.dto.SiteDTO;
import com.mdx.admin.api.pojo.dto.SiteUrlDTO;
import com.mdx.admin.api.req.SiteCreateReq;
import com.mdx.admin.api.req.SiteDeleteReq;
import com.mdx.admin.api.req.SiteUrlDeleteReq;
import com.mdx.admin.api.req.SiteUrlImportantCreateReq;
import com.mdx.admin.provider.authorization.annotation.Authorization;
import com.mdx.admin.provider.service.AdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "管理员后台重点页面接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */
public class SiteUrlController implements SiteUrlApi {

    @Autowired
    private AdminService adminService;


    @Override
    @Authorization
    public ObjectResp<SiteUrlDTO> createSiteUrlImportant(@Valid @RequestBody SiteUrlImportantCreateReq req) {
        return adminService.createSiteUrlImportant(req);
    }

    @Override
    @Authorization
    public ObjectResp<PageInfo<SiteUrlDTO>> listSiteUrlImportant(int siteId, int pageNumber, int pageSize) {
        return adminService.listSiteUrlImportant(siteId, pageNumber, pageSize);
    }


    @Override
    @Authorization
    public ObjectResp<Integer> deleteSiteUrlImportant(@Valid @RequestBody SiteUrlDeleteReq req) {
        return adminService.deleteSiteUrlImportant(req);
    }
}
