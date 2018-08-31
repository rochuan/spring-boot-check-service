package com.mdx.admin.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("站点DTO")
public class SiteDTO {
    @ApiModelProperty("站点ID")
    private Integer siteId;
    @ApiModelProperty("站点名称")
    private String siteName;
    @ApiModelProperty("站点：没有http或者https")
    private String allowDomains;
    @ApiModelProperty("检测首页：有http或者https")
    private String startUrls;
    @ApiModelProperty("站点英文code")
    private String code;
    @ApiModelProperty("创建时间")
    private Date gmtCreated;
    @ApiModelProperty("状态")
    private Integer status;



    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAllowDomains() {
        return allowDomains;
    }

    public void setAllowDomains(String allowDomains) {
        this.allowDomains = allowDomains;
    }

    public String getStartUrls() {
        return startUrls;
    }

    public void setStartUrls(String startUrls) {
        this.startUrls = startUrls;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}