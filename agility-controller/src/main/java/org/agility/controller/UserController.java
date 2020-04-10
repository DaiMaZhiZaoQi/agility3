package org.agility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sx.agility.service.ServiceUserImp;
import com.sx.agility.service.UserService;
import com.sx.model.entity.UserEntity;

@Controller
public class UserController {

	@Autowired 
	UserService mUserService;
	
	   @GetMapping("/test")
	    public String test(@RequestParam(value = "name",defaultValue = "zhang")String name) {
	    	ServiceUserImp.serviceTest();
	    	List<UserEntity> findAll = mUserService.findAll();
	    	System.out.println("test-->"+findAll.get(0).mToString());
	    	return String.format("hello %s!", name);
	    }
}
