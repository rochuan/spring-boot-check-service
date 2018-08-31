package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("AccessToken登录认证DTO")
public class AccessTokenDTO {

    @ApiModelProperty("过期时间：默认7200秒")
    private Long expireIn;

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("登录信息DTO")
    private AdminDTO userInfo;

    public Long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Long expireIn) {
        this.expireIn = expireIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AdminDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(AdminDTO userInfo) {
        this.userInfo = userInfo;
    }
}
