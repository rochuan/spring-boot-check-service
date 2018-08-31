package com.mdx.admin.api.pojo.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("检测统计DTO")
public class CountCheckDTO {

    @ApiModelProperty("首页统计")
    private Integer homepageCount;
    @ApiModelProperty("重点页面检测统计")
    private Integer impotantCount;
    @ApiModelProperty("全站检测统计")
    private Integer allPageCount;

    public Integer getHomepageCount() {
        return homepageCount;
    }

    public void setHomepageCount(Integer homepageCount) {
        this.homepageCount = homepageCount;
    }

    public Integer getImpotantCount() {
        return impotantCount;
    }

    public void setImpotantCount(Integer impotantCount) {
        this.impotantCount = impotantCount;
    }

    public Integer getAllPageCount() {
        return allPageCount;
    }

    public void setAllPageCount(Integer allPageCount) {
        this.allPageCount = allPageCount;
    }
}