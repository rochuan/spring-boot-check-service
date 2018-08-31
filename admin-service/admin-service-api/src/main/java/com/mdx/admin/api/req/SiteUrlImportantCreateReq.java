package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("重点页面创建请求")
public class SiteUrlImportantCreateReq {

    @ApiModelProperty(value = "管理员ID" , hidden = true)
    private Integer adminUserId;

    @ApiModelProperty("站点ID")
    @NotNull
    private Integer siteId;

    @ApiModelProperty(value = "0 homepage, 1 important url, 2 pip, 3 others,4 custom" , hidden = true)
    private Integer urlType = 1;

    @ApiModelProperty("内容:必传")
    @NotNull
    private List<String> urls;

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

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
