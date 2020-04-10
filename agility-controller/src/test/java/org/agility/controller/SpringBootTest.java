package org.agility.controller;

import java.util.List;

import javax.print.attribute.standard.Fidelity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.sx.agility.service.UserService;
import com.sx.model.entity.UserEntity;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes={App.class})// 指定启动类
public class SpringBootTest {

	@Autowired
	UserService mUserService;
	
	@Test
	public void testData() {
		List<UserEntity> findAll = mUserService.findAll();
		System.out.println(findAll.size());
	}
}
