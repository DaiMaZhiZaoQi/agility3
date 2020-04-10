package com.sx.dao;

import com.sx.model.entity.MUserEntity;

public class DaoUserMapper {
		
	public void impFun() {
		MUserEntity mUserEntity = new MUserEntity();
		mUserEntity.setPassword("123");
		mUserEntity.setUserName("张三");  
		System.out.println(mUserEntity.mToString());
	}
	
	public static void main(String[] args) {
		DaoUserMapper daoUserMapper = new DaoUserMapper();
		daoUserMapper.impFun();
		
	}
}
