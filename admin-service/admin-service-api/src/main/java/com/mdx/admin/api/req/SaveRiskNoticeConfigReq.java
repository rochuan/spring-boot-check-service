package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("保存风险通知请求")
public class SaveRiskNoticeConfigReq {

    @ApiModelProperty("手机")
    @NotNull
    private List<String> mobiles;

    @ApiModelProperty("email")
    @NotNull
    private List<String> emails;


    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
