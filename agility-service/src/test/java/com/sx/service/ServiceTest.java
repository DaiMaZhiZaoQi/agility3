package com.sx.service;

import org.junit.Test;

import com.agility.model.entity.MUserEntity;

public class ServiceTest {

	@Test
	public void serviceTest() {
		MUserEntity mUserEntity = new MUserEntity();
		mUserEntity.setUserName("fasfd");
		mUserEntity.setPassword("12111");
		System.out.println("====>"+mUserEntity.mToString());
	}
}
