package com.agility.service.imp;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.agility.model.entity.Role;
import com.agility.service.IRoleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Service
public class RoleServiceImp implements IRoleService {

	@Override
	public boolean saveBatch(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(Role entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role getOne(Wrapper<Role> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<Role> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<Role> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
