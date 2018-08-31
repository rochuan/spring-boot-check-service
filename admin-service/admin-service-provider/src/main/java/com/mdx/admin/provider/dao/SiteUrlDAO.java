package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.SiteUrlDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteUrlDAO {
    int insert(SiteUrlDTO record);

    int insertSelective(SiteUrlDTO record);

    int deleteByPrimaryKey(@Param("siteUrlId") Integer siteUrlId);

    List<SiteUrlDTO> listSiteUrlImportant(@Param("siteId") Integer siteId, @Param("pageNumber") Integer pageNumber, @Param("pageSize") Integer pageSize);

    int countHomepage(@Param("siteId") Integer siteId);
    int countImpotant(@Param("siteId") Integer siteId);
    int countAllPage(@Param("siteId") Integer siteId);
}