package com.mdx.spider.provider.controller;


import com.mdx.common.ObjectResp;
import com.mdx.spider.api.SpiderApi;
import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import com.mdx.spider.api.pojo.dto.SpiderSiteUrResponselDTO;
import com.mdx.spider.api.req.SpiderSiteCreateReq;
import com.mdx.spider.provider.authorization.annotation.Auth;
import com.mdx.spider.provider.excutor.SpiderPageExcutor;
import com.mdx.spider.provider.service.ISpiderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "爬虫页面接口")
@RestController

/**
 * 控制器
 *
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-09-30
 */
public class SpiderSiteController implements SpiderApi {


    @Autowired
    private SpiderPageExcutor spiderPageExcutor;

    @Override
    public ObjectResp<SiteUrlDO> getSiteSpider(@Valid @RequestBody SpiderSiteCreateReq req) {
        return null;
    }

    @Override
    public ObjectResp<SpiderSiteUrResponselDTO> doSpider(@Valid @RequestBody SpiderSiteCreateReq req) {
        SpiderSiteUrResponselDTO spiderSiteUrResponselDTO = spiderPageExcutor.run(spiderPageExcutor, req.getSiteId(), req.getSiteUrl());
        return new ObjectResp<SpiderSiteUrResponselDTO>(spiderSiteUrResponselDTO);
    }
}
