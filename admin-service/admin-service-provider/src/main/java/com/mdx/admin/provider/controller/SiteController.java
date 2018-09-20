package com.mdx.admin.provider.controller;

import com.mdx.admin.api.SiteApi;

import com.mdx.admin.api.pojo.dto.SiteDTO;
import com.mdx.admin.api.req.SiteCreateReq;
import com.mdx.admin.api.req.SiteDeleteReq;
import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.service.IAdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "管理员后台站点接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */
@Auth
public class SiteController implements SiteApi {

    @Autowired
    private IAdminService adminService;


    @Override
    @Auth
    public ObjectResp<SiteDTO> getSite(Integer siteId) {
        ObjectResp<SiteDTO> siteDTOObjectResp = adminService.getSite(siteId);
        return siteDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<SiteDTO> createSite(@Valid @RequestBody SiteCreateReq req) {

        ObjectResp<SiteDTO> siteDTOObjectResp = adminService.createSite(req);
        return siteDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<List<SiteDTO>> listSite() {
        ObjectResp<List<SiteDTO>> listObjectResp = adminService.listSite(1, 9999);
        return listObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<Integer> deleteSite(@Valid @RequestBody SiteDeleteReq req) {
        ObjectResp<Integer> integerObjectResp = adminService.deleteSite(req);
        return integerObjectResp;
    }
}
