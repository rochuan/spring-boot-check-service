package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.KeywordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeywordDAO {
    int deleteByPrimaryKey(Integer keywordId);

    int insert(KeywordDTO record);

    int insertSelective(KeywordDTO record);

    KeywordDTO selectByPrimaryKey(Integer keywordId);

    KeywordDTO selectByPrimaryKeyword(@Param("keyword") String keyword);

    int updateByPrimaryKeySelective(KeywordDTO record);

    int updateByPrimaryKey(KeywordDTO record);

    List<KeywordDTO> listKeyword(@Param("pageNumber") Integer pageNumber , @Param("pageSize") Integer pageSize);
}