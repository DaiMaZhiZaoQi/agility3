package com.agility.service;

import com.agility.common.HelloMaven;
import com.agility.model.entity.MUserEntity;

public class ServiceUserImp {
	public static MUserEntity serviceTest() {
		MUserEntity mUserEntity = new MUserEntity();
		mUserEntity.setUserName("fasfd");
		mUserEntity.setPassword("12111");
		System.out.println("====>"+mUserEntity.mToString());
		HelloMaven helloMaven = new HelloMaven();
		String testMaven = helloMaven.testMaven("fsaf");
		System.out.println("test"+testMaven);
		return mUserEntity;
	}
	public static void main(String[] args) {
		ServiceUserImp.serviceTest();
	}
}
