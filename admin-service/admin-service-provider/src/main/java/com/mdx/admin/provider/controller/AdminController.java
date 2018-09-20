package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.req.AdminCreateReq;
import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.config.UserSession;
import com.mdx.admin.provider.service.IAdminService;
import com.mdx.admin.api.AdminApi;
import com.mdx.admin.api.error.ErrorCode;
import com.mdx.admin.api.pojo.dto.AdminDTO;
import com.mdx.admin.api.req.AdminLoginReq;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "管理员后台登录接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */
public class AdminController implements AdminApi {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private UserSession userSession;

    @Override
    public ObjectResp<AccessTokenDTO> userLogin(@Valid @RequestBody AdminLoginReq req) {

        ObjectResp<AccessTokenDTO> adminDTOObjectResp = adminService.login(req);
        return adminDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<AdminDTO> getAdmin() {

        Long userId = userSession.getUserId();

        if (null == userId || 0 == userId) {
            return new ObjectResp<>(ErrorCode.EMPTY_USER_ID);
        }
        ObjectResp<AdminDTO> adminDTOObjectResp = adminService.getAdmin(userId);

        return adminDTOObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<AccessTokenDTO> logout() {
        Long userId = userSession.getUserId();
        if (null == userId || 0 == userId) {
            return new ObjectResp(ErrorCode.EMPTY_USER_ID);
        }
        ObjectResp<AccessTokenDTO> resp = adminService.logout(userId);

        return resp;
    }

    @Override
    @Auth
    public ObjectResp<PageInfo<AdminDTO>> listAdmin(int pageNumber, int pageSize) {
        ObjectResp<PageInfo<AdminDTO>> listAdminObjectResp = adminService.listAdmin(pageNumber, pageSize);
        return listAdminObjectResp;
    }

    @Override
    @Auth
    public ObjectResp<AccessTokenDTO> createAdmin(@Valid AdminCreateReq req) {
        return null;
    }


}
