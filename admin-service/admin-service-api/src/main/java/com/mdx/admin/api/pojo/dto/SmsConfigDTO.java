package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("短信配置DTO")
public class SmsConfigDTO {
    @ApiModelProperty("短信账号")
    private String smsConfigKey;
    @ApiModelProperty("短信密码")
    private String smsConfigSecret;
    @ApiModelProperty("短信签名")
    private String smsConfigSign;
    @ApiModelProperty("短信模版")
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
