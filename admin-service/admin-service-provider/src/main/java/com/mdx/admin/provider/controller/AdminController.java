package com.mdx.admin.provider.controller;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.pojo.dto.CaptchaDTO;
import com.mdx.admin.api.req.AdminCreateReq;
import com.mdx.admin.api.utils.CaptchaUtil;
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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

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
    public void getCaptcha() {
        //利用图片工具生成图片

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        HttpSession session = request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = CaptchaUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode", objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException ex) {
            System.out.println("error");
        }
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
