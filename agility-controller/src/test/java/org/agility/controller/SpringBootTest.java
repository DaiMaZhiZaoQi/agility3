package org.agility.controller;

import java.util.List;

import javax.print.attribute.standard.Fidelity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.agility.App;
import com.agility.model.entity.UserEntity;
import com.agility.service.UserService;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes={App.class})// 指定启动类
public class SpringBootTest {   
	@Autowired
	UserService mUserService;
	@Test
	public void testData() {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("李四");
		System.out.println(	mUserService.saveOrUpdate(userEntity));
	}
}
