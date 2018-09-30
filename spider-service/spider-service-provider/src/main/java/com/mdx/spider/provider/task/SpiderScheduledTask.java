package com.mdx.spider.provider.task;

import com.mdx.spider.api.pojo.domain.SiteDO;
import com.mdx.spider.api.pojo.dto.SpiderSiteUrResponselDTO;
import com.mdx.spider.provider.excutor.SpiderPageExcutor;
import com.mdx.spider.provider.service.ISpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SpiderScheduledTask {

    private static Logger logger = Logger.getLogger(String.valueOf(SpiderScheduledTask.class));

    @Autowired
    private ISpiderService iSpiderService;

    @Autowired
    private SpiderPageExcutor spiderPageExcutor;

    /**
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron="*5*****") ：通过cron表达式定义规则
     */
    @Scheduled(initialDelay = 1000 * 60 * 15 , fixedDelay = 1000 * 60 * 60 )
    public void spiderSiteTask() {
        //0 未扫瞄 1 扫描中 2 扫描完成
        int spiderStatus = 0;
        SiteDO siteDO = iSpiderService.getSiteBySpiderStatus(spiderStatus);
        logger.info(siteDO.toString());
        if (null == siteDO || null == siteDO.getSiteId()) {
            logger.info("没有网站需要爬虫！");
            return;
        }
        SpiderSiteUrResponselDTO spiderSiteUrResponselDTO = spiderPageExcutor.run(spiderPageExcutor, siteDO.getSiteId(), siteDO.getSiteUrl());
        logger.info(spiderSiteUrResponselDTO.toString());
    }
}
