package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("用户登录请求")
public class AdminLoginReq {

    @ApiModelProperty("账号名称")
    @NotNull
    private String account;

    @ApiModelProperty("密码")
    @NotNull
    private String password;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
