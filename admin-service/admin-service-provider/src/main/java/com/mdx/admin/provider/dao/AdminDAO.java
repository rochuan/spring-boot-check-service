package com.mdx.admin.provider.dao;

import com.mdx.admin.api.pojo.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * admin数据库访问层
 *
 *
 * @author  jeff.luo
 * @email rochuan@163.com
 * @Date 2018-08-13
 */

@Mapper
public interface AdminDAO {

    /**
     * 根据用户id获取管理员信息
     *
     * @param adminId
     * @return
     */
    AdminDTO getAdmin(@Param("adminId") Long adminId);

    /**
     * 根据用户id获取管理员信息
     *
     * @param userId
     * @return
     */
    AdminDTO getAdminByAccount(@Param("account") String account);


    /**
     * 根据用户id获取管理员信息
     *
     * @param adminId
     * @return
     */
    List<AdminDTO> listAdmin(@Param("pageNumber") Integer pageNumber , @Param("pageSize") Integer pageSize);

    int insertAdmin(AdminDTO adminDTO);
}
