package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("系统配置DTO")
public class ConfigDTO {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("自定义key")
    private String configKey;

    @ApiModelProperty("自定义分类ID")
    private Integer configCategoryId;
    @ApiModelProperty("自定义秘药")
    private String configValue;
    @ApiModelProperty("描述值")
    private String comment;
    @ApiModelProperty("是否启用")
    private Byte isActive;
    @ApiModelProperty("状态")
    private Short status;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;
    @ApiModelProperty("更新时间")
    private Date gmtUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public Integer getConfigCategoryId() {
        return configCategoryId;
    }

    public void setConfigCategoryId(Integer configCategoryId) {
        this.configCategoryId = configCategoryId;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
}