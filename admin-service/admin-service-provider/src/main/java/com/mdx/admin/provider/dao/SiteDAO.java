package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.SiteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteDAO {
    int deleteByPrimaryKey(Integer siteId);

    int insert(SiteDTO record);

    int insertSelective(SiteDTO record);

    SiteDTO selectByPrimaryKey(Integer siteId);

    SiteDTO selectByPrimaryName(@Param("siteName") String siteName);

    int updateByPrimaryKeySelective(SiteDTO record);

    int updateByPrimaryKey(SiteDTO record);

    List<SiteDTO> listSite();
}