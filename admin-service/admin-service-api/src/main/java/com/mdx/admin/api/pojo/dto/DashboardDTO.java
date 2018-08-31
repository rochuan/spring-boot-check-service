package com.mdx.admin.api.pojo.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("DashboardDTO")
public class DashboardDTO {

    @ApiModelProperty("首页检测DTO")
    private TaskRecordDTO homepageDTO;
    @ApiModelProperty("重点页面检测DTO")
    private TaskRecordDTO impotantDTO;
    @ApiModelProperty("全站检测DTO")
    private TaskRecordDTO allPageDTO;
    @ApiModelProperty("自定义检测DTO")
    private TaskRecordDTO customDTO;

    @ApiModelProperty("风险数据DTO")
    private PageInfo<SiteCheckTaskLogDTO> siteCheckTaskLogDTO;

    public TaskRecordDTO getHomepageDTO() {
        return homepageDTO;
    }

    public void setHomepageDTO(TaskRecordDTO homepageDTO) {
        this.homepageDTO = homepageDTO;
    }

    public TaskRecordDTO getImpotantDTO() {
        return impotantDTO;
    }

    public void setImpotantDTO(TaskRecordDTO impotantDTO) {
        this.impotantDTO = impotantDTO;
    }

    public TaskRecordDTO getAllPageDTO() {
        return allPageDTO;
    }

    public void setAllPageDTO(TaskRecordDTO allPageDTO) {
        this.allPageDTO = allPageDTO;
    }

    public TaskRecordDTO getCustomDTO() {
        return customDTO;
    }

    public void setCustomDTO(TaskRecordDTO customDTO) {
        this.customDTO = customDTO;
    }

    public PageInfo<SiteCheckTaskLogDTO> getSiteCheckTaskLogDTO() {
        return siteCheckTaskLogDTO;
    }

    public void setSiteCheckTaskLogDTO(PageInfo<SiteCheckTaskLogDTO> siteCheckTaskLogDTO) {
        this.siteCheckTaskLogDTO = siteCheckTaskLogDTO;
    }
}