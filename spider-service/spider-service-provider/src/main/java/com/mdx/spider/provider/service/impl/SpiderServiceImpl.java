package com.mdx.spider.provider.service.impl;


import com.mdx.common.ObjectResp;
import com.mdx.spider.api.error.ErrorCode;
import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import com.mdx.spider.api.req.SpiderSiteCreateReq;
import com.mdx.spider.provider.dao.SiteUrlDAO;
import com.mdx.spider.provider.excutor.SpiderPageExcutor;
import com.mdx.spider.provider.service.ISpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * 管理员服务
 *
 * @author jeff.luo
 * @email rochuan@163.com
 * @Date 2018-09-30
 */
@Service
public class SpiderServiceImpl implements ISpiderService {


    @Autowired
    private SiteUrlDAO siteUrlDAO;

    @Override
    public ObjectResp<SiteUrlDO> getSiteSpider(SpiderSiteCreateReq req) {
        return new ObjectResp<>();
    }

    @Override
    public SiteUrlDO insertSpiderSiteUrl(Integer siteId, String url) {
        SiteUrlDO siteUrlDO = new SiteUrlDO();
        siteUrlDO.setSiteId(siteId);
        siteUrlDO.setUrl(url);
        siteUrlDO.setCheckType(0);
        siteUrlDO.setUrlContentType(0);
        siteUrlDO.setUrlType(0);
        siteUrlDO.setGmtCreated(new Date());
        int lastInsertId = siteUrlDAO.insert(siteUrlDO);
        if (lastInsertId <= 0) {
            return null;
        }
        return siteUrlDO;
    }
}
