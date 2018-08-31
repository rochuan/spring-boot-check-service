package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("保存短信配置请求")
public class SaveSmsConfigReq {

    @ApiModelProperty("账号")
    @NotNull
    private String smsConfigKey;

    @ApiModelProperty("密码")
    @NotNull
    private String smsConfigSecret;

    @ApiModelProperty("签名")
    @NotNull
    private String smsConfigSign;

    @ApiModelProperty("模版ID")
    @NotNull
    private String smsConfigTemplateId;

    public String getSmsConfigKey() {
        return smsConfigKey;
    }

    public void setSmsConfigKey(String smsConfigKey) {
        this.smsConfigKey = smsConfigKey;
    }

    public String getSmsConfigSecret() {
        return smsConfigSecret;
    }

    public void setSmsConfigSecret(String smsConfigSecret) {
        this.smsConfigSecret = smsConfigSecret;
    }

    public String getSmsConfigSign() {
        return smsConfigSign;
    }

    public void setSmsConfigSign(String smsConfigSign) {
        this.smsConfigSign = smsConfigSign;
    }

    public String getSmsConfigTemplateId() {
        return smsConfigTemplateId;
    }

    public void setSmsConfigTemplateId(String smsConfigTemplateId) {
        this.smsConfigTemplateId = smsConfigTemplateId;
    }
}
