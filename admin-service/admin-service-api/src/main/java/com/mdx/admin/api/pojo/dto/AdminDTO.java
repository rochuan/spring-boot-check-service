package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("登录信息DTO")
public class AdminDTO {

    @ApiModelProperty("管理员ID")
    private Long adminId;

    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("管理员名字")
    private String adminName;
    @ApiModelProperty("管理员手机号")
    private String mobile;
    @ApiModelProperty(value = "密码" ,hidden = true)
    private String password;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("盐")
    private String salt;
    @ApiModelProperty("头像：路径")
    private String avatar;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;
    @ApiModelProperty("更新时间")
    private Date gmtUpdated;
    @ApiModelProperty("最近一次登录日期")
    private Date gmtLastLogin;
    @ApiModelProperty("状态")
    private Integer status;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public Date getGmtLastLogin() {
        return gmtLastLogin;
    }

    public void setGmtLastLogin(Date gmtLastLogin) {
        this.gmtLastLogin = gmtLastLogin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
