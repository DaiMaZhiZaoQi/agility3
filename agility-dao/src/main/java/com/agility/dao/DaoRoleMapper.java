package com.agility.dao;

import javax.xml.ws.RespectBinding;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.agility.model.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */

@Mapper
public interface DaoRoleMapper extends BaseMapper<Role> {

}
