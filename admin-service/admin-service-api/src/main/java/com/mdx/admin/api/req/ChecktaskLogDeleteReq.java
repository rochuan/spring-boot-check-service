package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("删除分页url请求")
public class ChecktaskLogDeleteReq {

    @ApiModelProperty("ID")
    @NotNull
    private Integer logId;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }
}
