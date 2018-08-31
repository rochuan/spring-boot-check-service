package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("创建检测报告邮件请求")
public class ReportEmailCreateReq {

    @ApiModelProperty("站点ID")
    @NotNull
    private Integer siteId;

    @ApiModelProperty("自定义批次ID，用于知道是那次调用")
    @NotNull
    private String reportId;

    @ApiModelProperty("reportType:0 homepage, 1 important url, 2 pip, 3 others,4 custom:全站：255")
    @NotNull
    private String reportType;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
