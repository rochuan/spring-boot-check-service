package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.ConfigDTO;
import com.mdx.admin.api.pojo.dto.EmailConfigDTO;
import com.mdx.admin.api.pojo.dto.SmsConfigDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigDAO {

    ConfigDTO selectConfigByConfigKey(@Param("configKey") String configKey);


    //获取短信
    List<ConfigDTO> selectSmsConfigList();

    //获取短信
    List<ConfigDTO> selectSmsEmailConfigList();

    //更新config key value
    int updateKVConfigSelective(@Param("configKey") String configKey, @Param("configValue") String configValue);


    int deleteByPrimaryKey(Integer id);

    int insert(ConfigDTO record);

    int insertSelective(ConfigDTO record);

    ConfigDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigDTO record);

    int updateByPrimaryKey(ConfigDTO record);
}