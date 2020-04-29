package com.agility.service;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.agility.model.entity.MUserEntity;
import com.agility.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;


public abstract class UserService implements IService<UserEntity>{

	@Override
	public boolean saveBatch(Collection<UserEntity> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<UserEntity> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<UserEntity> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(UserEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity getOne(Wrapper<UserEntity> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<UserEntity> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<UserEntity> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<UserEntity> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
