package com.mdx.admin.api.pojo.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("检测报告DTO")
public class CheckReportDTO {
    @ApiModelProperty("站点DTO")
    private SiteDTO siteDTO;
    @ApiModelProperty("检测任务DTO")
    private TaskRecordDTO taskRecordDTO;
    @ApiModelProperty("风险页面DTO")
    private PageInfo<SiteCheckTaskLogDTO> riskReportListDTO;
    @ApiModelProperty("检测网址DTO")
    private PageInfo<SiteCheckTaskLogDTO> checkReportListDTO;

    public SiteDTO getSiteDTO() {
        return siteDTO;
    }

    public void setSiteDTO(SiteDTO siteDTO) {
        this.siteDTO = siteDTO;
    }

    public TaskRecordDTO getTaskRecordDTO() {
        return taskRecordDTO;
    }

    public void setTaskRecordDTO(TaskRecordDTO taskRecordDTO) {
        this.taskRecordDTO = taskRecordDTO;
    }

    public PageInfo<SiteCheckTaskLogDTO> getRiskReportListDTO() {
        return riskReportListDTO;
    }

    public void setRiskReportListDTO(PageInfo<SiteCheckTaskLogDTO> riskReportListDTO) {
        this.riskReportListDTO = riskReportListDTO;
    }

    public PageInfo<SiteCheckTaskLogDTO> getCheckReportListDTO() {
        return checkReportListDTO;
    }

    public void setCheckReportListDTO(PageInfo<SiteCheckTaskLogDTO> checkReportListDTO) {
        this.checkReportListDTO = checkReportListDTO;
    }
}
