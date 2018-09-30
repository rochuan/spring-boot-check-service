package com.mdx.spider.provider.excutor;

import com.mdx.common.TimeUtil;
import com.mdx.spider.api.pojo.domain.SiteDO;
import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import com.mdx.spider.api.pojo.dto.SpiderSiteUrResponselDTO;
import com.mdx.spider.provider.dao.SiteUrlDAO;
import com.mdx.spider.provider.service.ISpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Date;
import java.util.logging.Logger;

@Component("SpiderPageExcutor")
public class SpiderPageExcutor implements PageProcessor {

    private static Logger logger = Logger.getLogger(String.valueOf(SpiderPageExcutor.class));


    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private String siteUrl;
    private Integer siteId;


    public SpiderPageExcutor() {

    }

    public SpiderPageExcutor(Integer siteId, String siteUrl) {
        this.siteUrl = siteUrl;
        this.siteId = siteId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @Autowired
    ISpiderService iSpiderService;

    @Override
    public void process(Page page) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(siteUrl);
        stringBuilder.append("/[\\w\\-]+");

        SiteUrlDO siteUrlDO = iSpiderService.insertSpiderSiteUrl(siteId, page.getUrl().toString());
        page.putField("siteUrlDO", siteUrlDO);
        logger.info("\n siteUrlDO logger " + siteUrlDO);
        page.addTargetRequests(page.getHtml().links().regex("(" + stringBuilder.toString() + ")").all());
    }

    private void setSite(Site site) {
        this.site = site;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public SpiderSiteUrResponselDTO run(SpiderPageExcutor spiderPageExcutor, Integer siteId, String siteUrl) {
        if (null == siteId || 0 == siteId) {
            return null;
        }
        if (null == siteUrl) {
            return null;
        }
        this.setSiteId(siteId);
        this.setSiteUrl(siteUrl);


        //修改爬虫为爬虫中
        SiteDO siteDO = new SiteDO();
        siteDO.setSiteId(siteId);
        int spiderStatus = 1;
        siteDO.setSpiderStatus(spiderStatus);
        long start = System.currentTimeMillis();
        Date spiderGmtCreated = new Date(start);
        siteDO.setSpiderGmtCreated(spiderGmtCreated);
        iSpiderService.updateSiteBySpiderStatus(siteDO);

        Spider.create(spiderPageExcutor).addUrl(siteUrl).thread(5).run();
        long end = System.currentTimeMillis();
        Date spiderGmtUpdated = new Date(end);

        String cost = TimeUtil.parseMillisecone(end - start);
        System.out.println("爬虫结束,耗时--->" + cost);

        //修改爬虫为爬虫完成
        spiderStatus = 2;
        siteDO.setSpiderStatus(spiderStatus);
        siteDO.setGmtUpdated(spiderGmtUpdated);
        siteDO.setCostValue(cost);
        siteDO.setSpriderGmtUpdated(spiderGmtUpdated);
        iSpiderService.updateSiteBySpiderStatus(siteDO);

        SpiderSiteUrResponselDTO spiderSiteUrResponselDTO = new SpiderSiteUrResponselDTO();
        spiderSiteUrResponselDTO.setGmtCreated(spiderGmtCreated);
        spiderSiteUrResponselDTO.setSiteId(siteId);
        spiderSiteUrResponselDTO.setSiteUrl(siteUrl);
        spiderSiteUrResponselDTO.setCost(cost);
        spiderSiteUrResponselDTO.setGmtUpdated(spiderGmtUpdated);

        return spiderSiteUrResponselDTO;
    }
}
