package com.mdx.spider.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("爬虫站点site请求")
public class SpiderSiteCreateReq {

    @ApiModelProperty("开始检测的主页(带http)")
    @NotNull
    private String siteUrl;

    @ApiModelProperty("站点ID")
    @NotNull
    private Integer siteId;

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
