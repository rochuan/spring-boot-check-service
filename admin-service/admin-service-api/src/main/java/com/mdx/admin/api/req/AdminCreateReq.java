package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("用户创建请求")
public class AdminCreateReq {

    @ApiModelProperty("账号")
    @NotNull
    private String account;

    @ApiModelProperty("名称")
    @NotNull
    private String username;

    @ApiModelProperty("密码")
    @NotNull
    private String password;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("电子邮件")
    private String email;


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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
