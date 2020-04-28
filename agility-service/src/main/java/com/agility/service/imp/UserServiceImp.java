package com.agility.service.imp;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agility.dao.DaoUserMapper;
import com.agility.model.entity.MUserEntity;
import com.agility.model.entity.Role;
import com.agility.model.entity.UserEntity;
import com.agility.service.IRoleService;
import com.agility.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Service
public  class UserServiceImp extends UserService{

	@Autowired
	DaoUserMapper mUserMapper;
	
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
	
	
	
	
	


}
