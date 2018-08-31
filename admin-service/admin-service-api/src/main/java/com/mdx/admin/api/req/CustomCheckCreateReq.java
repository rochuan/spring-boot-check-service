package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("人工检查创建请求")
public class CustomCheckCreateReq {

    @ApiModelProperty("管理员ID")
    @NotNull
    private Integer adminUserId;

    @ApiModelProperty("站点ID")
    @NotNull
    private Integer siteId;

    @ApiModelProperty("0 homepage, 1 important url, 2 pip, 3 others,4 custom")
    @NotNull
    private Integer urlType;

    @ApiModelProperty("内容：如果为4 必传")
    private List<String> content;

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
