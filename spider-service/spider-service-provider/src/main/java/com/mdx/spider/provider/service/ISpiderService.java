package com.mdx.spider.provider.service;

import com.github.pagehelper.PageInfo;
import com.mdx.common.ObjectResp;
import com.mdx.spider.api.pojo.domain.SiteDO;
import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import com.mdx.spider.api.req.SpiderSiteCreateReq;

import java.util.List;


/**
 * 管理员服务
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-09-30
 */
public interface ISpiderService {

    ObjectResp<SiteUrlDO> getSiteSpider(SpiderSiteCreateReq req);

    SiteUrlDO insertSpiderSiteUrl(Integer siteId, String url);

    SiteDO getSiteBySpiderStatus(Integer spiderStatus);

    int updateSiteBySpiderStatus(SiteDO siteDO);

}
