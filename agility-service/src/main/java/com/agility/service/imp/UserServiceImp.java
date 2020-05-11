package com.agility.service.imp;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.agility.common.jsonutils.JsonUtils;
import com.agility.common.redis.RedisUtils;
import com.agility.dao.DaoRoleMapper;
import com.agility.dao.DaoUserMapper;
import com.agility.model.entity.MUserEntity;
import com.agility.model.entity.Role;
import com.agility.model.entity.UserEntity;
import com.agility.service.IRoleService;
import com.agility.service.UserService;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Service
public  class UserServiceImp extends UserService implements UserDetailsService{
	static final Logger log=LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	DaoUserMapper mUserMapper;
	
	@Autowired
	DaoRoleMapper mDaoRoleMapper;
	@Transactional
	@Override
	public boolean saveOrUpdate(UserEntity entity) {
		 boolean result=mUserMapper.inserts(entity)>0?true:false;
//		 int i=1/0;
		 return result;
//		return false;
	}

	@Override
	public UserEntity getById(Serializable id) {
		// TODO Auto-generated method stub
		return mUserMapper.selectById(id);
	}

	@Transactional  //    不加 @Transactional  报 will not be managed by Spring这个提示 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("username", username);
		String json = (String) RedisUtils.get("user");
		List<UserEntity> listUser =null;
		if(StringUtils.isEmpty(json)) {
				 listUser = mUserMapper.selectByMap(map);
				 if(listUser!=null) {
						for(UserEntity user:listUser) {
							List<Role> listRole = mDaoRoleMapper.selectByUserId(user.getId());
							user.setRoles(listRole);
						}
						 String jsonUser = JsonUtils.toJSon(listUser);
						 log.info("listUser--->"+jsonUser);
						RedisUtils.set("user", jsonUser); 
				}
		}else {
			log.info("json-->"+json);
			UserEntity[] userEntities = JsonUtils.readValue(json,UserEntity[].class);
			listUser=Arrays.asList(userEntities);
		}
		
		
	
		
//		log.info("loadUserByUserName{}",userEntity.mToString());
		return listUser.get(0);
	}
	

}
