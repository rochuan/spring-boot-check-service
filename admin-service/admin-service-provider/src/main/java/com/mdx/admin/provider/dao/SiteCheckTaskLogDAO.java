package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.SiteCheckTaskLogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteCheckTaskLogDAO {
    int deleteByPrimaryKey(Integer logId);

    int insert(SiteCheckTaskLogDTO record);

    int insertSelective(SiteCheckTaskLogDTO record);

    SiteCheckTaskLogDTO selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SiteCheckTaskLogDTO record);

    int updateByPrimaryKey(SiteCheckTaskLogDTO record);

    List<SiteCheckTaskLogDTO> listRiskLog(@Param("siteId") Integer siteId , @Param("pageNumber") Integer pageNumber , @Param("pageSize") Integer pageSize );

    List<SiteCheckTaskLogDTO> getRiskReportList(@Param("siteId") Integer siteId ,@Param("reportId") String reportId , @Param("pageNumber") Integer pageNumber , @Param("pageSize") Integer pageSize);

    List<SiteCheckTaskLogDTO> getCheckReportList(@Param("siteId") Integer siteId ,@Param("reportId") String reportId , @Param("pageNumber") Integer pageNumber , @Param("pageSize") Integer pageSize);
}