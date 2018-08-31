package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.AdminApi;
import com.mdx.admin.api.KeywordApi;

import com.mdx.admin.api.error.ErrorCode;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.pojo.dto.AdminDTO;
import com.mdx.admin.api.pojo.dto.KeywordDTO;
import com.mdx.admin.api.req.AdminLoginReq;
import com.mdx.admin.api.req.KeywordCreateReq;
import com.mdx.admin.api.req.KeywordDeleteReq;
import com.mdx.admin.provider.authorization.annotation.Authorization;
import com.mdx.admin.provider.service.AdminService;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
    private AdminService adminService;


    @Override
    @Authorization
    public ObjectResp<KeywordDTO> getKeyword(Integer keywordId) {
        ObjectResp<KeywordDTO> keywordDTOObjectResp = adminService.getKeyword(keywordId);
        return keywordDTOObjectResp;
    }

    @Override
    @Authorization
    public ObjectResp<KeywordDTO> createKeyword(@Valid @RequestBody KeywordCreateReq req) {

        ObjectResp<KeywordDTO> keywordDTOObjectResp = adminService.createKeyword(req);
        return keywordDTOObjectResp;
    }

    @Override
    @Authorization
    public ObjectResp<PageInfo<KeywordDTO>> listKeyword(int pageNumber, int pageSize) {
        ObjectResp<PageInfo<KeywordDTO>> listObjectResp = adminService.listKeyword(pageNumber, pageSize);
        return listObjectResp;
    }

    @Override
    @Authorization
    public ObjectResp<Integer> deleteKeyword(@Valid @RequestBody KeywordDeleteReq req) {
        ObjectResp<Integer> keywordDTOObjectResp = adminService.deleteKeyword(req);
        return keywordDTOObjectResp;
    }
}
