package com.mdx.admin.api.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("创建站点site请求")
public class SiteCreateReq {

    @ApiModelProperty("名称")
    @NotNull
    private String siteName;

    @ApiModelProperty("站点(oschina.net)\\n")
    @NotNull
    private String allow_domains;

    @ApiModelProperty("开始检测的主页(带http)")
    @NotNull
    private String start_urls;

    @ApiModelProperty("编码")
    @NotNull
    private String code;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAllow_domains() {
        return allow_domains;
    }

    public void setAllow_domains(String allow_domains) {
        this.allow_domains = allow_domains;
    }

    public String getStart_urls() {
        return start_urls;
    }

    public void setStart_urls(String start_urls) {
        this.start_urls = start_urls;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
