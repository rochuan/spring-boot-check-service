package com.mdx.spider.provider.dao;

import com.mdx.spider.api.pojo.domain.SiteDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteDAO {

    SiteDO selectByPrimaryKey(Integer siteId);

    SiteDO selectSiteBySpiderStatus(Integer spiderStatus);

    int updateByPrimaryKeySelective(SiteDO siteDO);

}