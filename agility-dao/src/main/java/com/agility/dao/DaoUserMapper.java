package com.agility.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.agility.model.entity.MUserEntity;
import com.agility.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface DaoUserMapper extends BaseMapper<UserEntity>{
		
	
	int inserts(UserEntity userEntity);
	
//	public void impFun() {
//		MUserEntity mUserEntity = new MUserEntity();
//		mUserEntity.setPassword("123");
//		mUserEntity.setUserName("张三");  
//		System.out.println(mUserEntity.mToString());
//	}
//	
//	public static void main(String[] args) {
//		DaoUserMapper daoUserMapper = new DaoUserMapper();
//		daoUserMapper.impFun();
//		
//	}
}
