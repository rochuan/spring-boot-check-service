package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.TaskRecordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskRecordDAO {
    int deleteByPrimaryKey(Integer id);

    TaskRecordDTO selectByPrimaryKey(Integer id);

    TaskRecordDTO selectBySiteId(@Param("siteId") Integer siteId , @Param("reportType") Integer reportType );

    TaskRecordDTO selectAllPage(@Param("siteId") Integer siteId);
}