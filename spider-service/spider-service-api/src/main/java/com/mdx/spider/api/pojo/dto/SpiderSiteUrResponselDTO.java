package com.mdx.spider.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("SpiderSiteUrResponselDTO")
public class SpiderSiteUrResponselDTO {

    @ApiModelProperty("站点ID")
    private Integer siteId;
    @ApiModelProperty("站点首页")
    private String siteUrl;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;
    @ApiModelProperty("结束时间")
    private Date gmtUpdated;
    @ApiModelProperty("耗时")
    private String cost;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "SpiderSiteUrResponselDTO{" +
                "siteId=" + siteId +
                ", siteUrl='" + siteUrl + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtUpdated=" + gmtUpdated +
                ", cost='" + cost + '\'' +
                '}';
    }
}