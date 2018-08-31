package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("保存email配置请求")
public class SaveEmailConfigReq {

    @ApiModelProperty("服务器server")
    @NotNull
    private String emailServer;

    @ApiModelProperty("服务器端口")
    @NotNull
    private String emailPort;

    @ApiModelProperty("服务器用户")
    @NotNull
    private String emailUser;

    @ApiModelProperty("服务器用户密码")
    @NotNull
    private String emailPassword;

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
}
