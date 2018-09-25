package com.mdx.admin.api;


import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.req.AdminCreateReq;
import com.mdx.admin.api.req.AdminLoginReq;
import com.mdx.admin.api.pojo.dto.AdminDTO;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@ApiIgnore
@RequestMapping("/v1/admin")
public interface AdminApi {


    @ApiOperation(value = "管理员登录(10001)")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ObjectResp<AccessTokenDTO> userLogin(@Valid @RequestBody AdminLoginReq req);

    @ApiOperation(value = "管理员用户获取(10002)")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<AdminDTO> getAdmin();

    @ApiOperation(value = "获取图片验证码(10002)")
    @RequestMapping(method = RequestMethod.GET, value = "/getCaptcha")
    public void getCaptcha() ;

    @ApiOperation(value = "管理员用户退出(10003)")
    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<AccessTokenDTO> logout();

    @ApiOperation(value = "管理员用户获取(10004)")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "accessToken", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<PageInfo<AdminDTO>> listAdmin(@RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);



    @ApiOperation(value = "管理员添加(10005)")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<AdminDTO> createAdmin(@Valid @RequestBody AdminCreateReq req);
}
