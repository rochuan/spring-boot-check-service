package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("URLDTO")
public class SiteUrlDTO {
    @ApiModelProperty("URLID")
    private Integer urlId;
    @ApiModelProperty("站点ID")
    private Integer siteId;
    @ApiModelProperty("URL")
    private String url;
    @ApiModelProperty("类型：0 homepage, 1 important url, 2 pip, 3 others,4 custom 全站：255")
    private Integer urlType;
    @ApiModelProperty("URL内容类型：0, html, 1 image")
    private Integer urlContentType;
    @ApiModelProperty("检测：0 text 1 image 2 ocr 3 image & ocr")
    private Integer checkType;
    @ApiModelProperty("报告ID 自定义页面出现")
    private String reportId;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    public Integer getUrlContentType() {
        return urlContentType;
    }

    public void setUrlContentType(Integer urlContentType) {
        this.urlContentType = urlContentType;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}