package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("检测任务DTO")
public class TaskRecordDTO {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("开始时间")
    private Date startAt;
    @ApiModelProperty("站点ID")
    private Integer siteId;
    @ApiModelProperty("结束时间")
    private Date endAt;
    @ApiModelProperty("总共检测多少个页面")
    private Integer checks;
    @ApiModelProperty("成功检测多少个页面")
    private Integer success;
    @ApiModelProperty("失败检测多少个页面")
    private Integer failed;
    @ApiModelProperty("可能有问题检测多少个页面")
    private Integer review;
    @ApiModelProperty("任务是否完成0,未完成，1已完成")
    private Integer taskEnd;
    @ApiModelProperty("可能有问题检测多少个页面")
    private Integer reportFlag;
    @ApiModelProperty("可能有问题检测多少个页面")
    private String reportId;
    @ApiModelProperty("0 homepage 1 important 2 pip 3 other 4 自定义 全站：255")
    private Integer reportType;
    @ApiModelProperty("条数")
    private Integer pageSize;
    @ApiModelProperty("位移")
    private Integer pageIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Integer getChecks() {
        return checks;
    }

    public void setChecks(Integer checks) {
        this.checks = checks;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getTaskEnd() {
        return taskEnd;
    }

    public void setTaskEnd(Integer taskEnd) {
        this.taskEnd = taskEnd;
    }

    public Integer getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}