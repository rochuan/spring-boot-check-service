package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("删除重点页面请求")
public class SiteUrlDeleteReq {

    @ApiModelProperty("ID")
    @NotNull
    private Integer siteUrlId;

    public Integer getSiteUrlId() {
        return siteUrlId;
    }

    public void setSiteUrlId(Integer siteUrlId) {
        this.siteUrlId = siteUrlId;
    }
}
