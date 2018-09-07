package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.KeywordApi;

import com.mdx.admin.api.pojo.dto.KeywordDTO;
import com.mdx.admin.api.req.KeywordCreateReq;
import com.mdx.admin.api.req.KeywordDeleteReq;
import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.service.IAdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "管理员后台关键词接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */
public class KeywordController implements KeywordApi {

    @Autowired
    private IAdminService adminService;


    @Override
    @Auth
    public ObjectResp<KeywordDTO> getKeyword(Integer keywordId) {
        ObjectResp<KeywordDTO> keywordDTOObjectResp = adminService.getKeyword(keywordId);
        return keywordDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<KeywordDTO> createKeyword(@Valid @RequestBody KeywordCreateReq req) {

        ObjectResp<KeywordDTO> keywordDTOObjectResp = adminService.createKeyword(req);
        return keywordDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<PageInfo<KeywordDTO>> listKeyword(int pageNumber, int pageSize) {
        ObjectResp<PageInfo<KeywordDTO>> listObjectResp = adminService.listKeyword(pageNumber, pageSize);
        return listObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<Integer> deleteKeyword(@Valid @RequestBody KeywordDeleteReq req) {
        ObjectResp<Integer> keywordDTOObjectResp = adminService.deleteKeyword(req);
        return keywordDTOObjectResp;
    }
}
