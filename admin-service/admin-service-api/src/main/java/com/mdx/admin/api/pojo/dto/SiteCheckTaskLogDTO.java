package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("监测报告记录DTO")
public class SiteCheckTaskLogDTO {
    @ApiModelProperty("ID")
    private Integer logId;
    @ApiModelProperty("检测任务ID：关联checkReportDTO")
    private Integer checkTaskId;
    @ApiModelProperty("URL地址ID：关联URLDTO")
    private Integer urlId;
    @ApiModelProperty("URL")
    private String url;
    @ApiModelProperty("检测结果：0 通过,1不通过,2疑似")
    private Integer checkResult;
    @ApiModelProperty("描述")
    private String checkResultDesc;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getCheckTaskId() {
        return checkTaskId;
    }

    public void setCheckTaskId(Integer checkTaskId) {
        this.checkTaskId = checkTaskId;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckResultDesc() {
        return checkResultDesc;
    }

    public void setCheckResultDesc(String checkResultDesc) {
        this.checkResultDesc = checkResultDesc == null ? null : checkResultDesc.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}