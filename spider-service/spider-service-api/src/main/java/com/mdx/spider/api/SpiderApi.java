package com.mdx.spider.api;


import com.mdx.common.ObjectResp;
import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import com.mdx.spider.api.pojo.dto.SpiderSiteUrResponselDTO;
import com.mdx.spider.api.req.SpiderSiteCreateReq;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@RequestMapping("/v1/spider/site")
public interface SpiderApi {

    @ApiOperation(value = "爬虫站点site(20101)")
    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<SiteUrlDO> getSiteSpider(@Valid @RequestBody SpiderSiteCreateReq req);


    @ApiOperation(value = "爬虫站点site(20101)")
    @RequestMapping(method = RequestMethod.POST, value = "/doSpider")
    public ObjectResp<SpiderSiteUrResponselDTO> doSpider(@Valid @RequestBody SpiderSiteCreateReq req);
}
