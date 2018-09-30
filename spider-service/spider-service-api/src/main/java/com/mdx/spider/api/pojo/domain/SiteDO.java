package com.mdx.spider.api.pojo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("站点DO")
public class SiteDO {
    @ApiModelProperty("站点ID")
    private Integer siteId;
    @ApiModelProperty("站点名称")
    private String siteName;
    @ApiModelProperty("检测首页：有http或者https")
    private String siteUrl;
    @ApiModelProperty("站点英文code")
    private String siteCode;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;
    @ApiModelProperty("更新时间")
    private Date gmtUpdated;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("爬虫状态 ： 0 未扫瞄 1 扫描中 2 扫描完成")
    private Integer spiderStatus;
    @ApiModelProperty("爬虫创建时间")
    private Date spiderGmtCreated;
    @ApiModelProperty("爬虫结束时间")
    private Date spriderGmtUpdated;
    @ApiModelProperty("耗时")
    private String costValue;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSpiderStatus() {
        return spiderStatus;
    }

    public void setSpiderStatus(Integer spiderStatus) {
        this.spiderStatus = spiderStatus;
    }

    public Date getSpiderGmtCreated() {
        return spiderGmtCreated;
    }

    public void setSpiderGmtCreated(Date spiderGmtCreated) {
        this.spiderGmtCreated = spiderGmtCreated;
    }

    public Date getSpriderGmtUpdated() {
        return spriderGmtUpdated;
    }

    public void setSpriderGmtUpdated(Date spriderGmtUpdated) {
        this.spriderGmtUpdated = spriderGmtUpdated;
    }

    public String getCostValue() {
        return costValue;
    }

    public void setCostValue(String costValue) {
        this.costValue = costValue;
    }

    @Override
    public String toString() {
        return "SiteDO{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtUpdated=" + gmtUpdated +
                ", status=" + status +
                ", spiderStatus=" + spiderStatus +
                ", spiderGmtCreated=" + spiderGmtCreated +
                ", spriderGmtUpdated=" + spriderGmtUpdated +
                ", costValue='" + costValue + '\'' +
                '}';
    }
}