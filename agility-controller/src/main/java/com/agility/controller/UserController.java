package com.agility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agility.dao.DaoRoleMapper;
import com.agility.dao.DaoUserMapper;
import com.agility.model.entity.MUserEntity;
import com.agility.model.entity.UserEntity;
import com.agility.service.ServiceUserImp;
import com.agility.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Controller
@RestController
@RequestMapping("/user/")
public class UserController extends BaseController{

	@Autowired
	DaoUserMapper mUserMapper;
	@Autowired
	DaoRoleMapper mRoleMapper;
	@Autowired
	UserService mUserService;
	
	   @GetMapping("test")
//	   @ResponseBody
	    public String test(@RequestParam(value = "name",defaultValue = "zhang")String name) {
	    	ServiceUserImp.serviceTest();
	    	List<UserEntity> findAll = mUserMapper.selectList(null);
	    	System.out.println("test-->"+findAll.get(0).mToString()+"===>"+String.format("hello %s!", name));
//	    	return String.format("hello %s!", name);
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	try {
	    		
	    		String json=objectMapper.writeValueAsString(findAll);
				return json;
			} catch (JsonProcessingException e) {   
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return "fail";
	    }
	   
	   
	   @ResponseBody
	   @RequestMapping("role")
	   public String selectRole(@RequestParam(value="id")String id) {
			ObjectMapper objectMapper = new ObjectMapper();
	    	try {
//	    		String json=objectMapper.writeValueAsString( mRoleMapper.selectById(id));
	    		String json=objectMapper.writeValueAsString( mUserService.getById(id));
	    		
				return json;
			} catch (JsonProcessingException e) {   
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return "fail";
	
	   }
	   
	   
	   
	   
}
