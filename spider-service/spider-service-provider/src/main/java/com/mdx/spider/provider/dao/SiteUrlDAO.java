package com.mdx.spider.provider.dao;


import com.mdx.spider.api.pojo.domain.SiteUrlDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteUrlDAO {
    int insert(SiteUrlDO record);

    int insertSelective(SiteUrlDO record);

    int deleteByPrimaryKey(@Param("siteUrlId") Integer siteUrlId);
}