package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.CustomCheckDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomCheckDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomCheckDTO record);

    int insertSelective(CustomCheckDTO record);

    CustomCheckDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomCheckDTO record);

    int updateByPrimaryKey(CustomCheckDTO record);
}