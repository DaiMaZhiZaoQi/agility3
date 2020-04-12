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

import com.agility.model.entity.UserEntity;
import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonpCharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.agility.service.ServiceUserImp;
import com.sx.agility.service.UserService;

//@Controller
@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired(required = true)
	UserService mUserService;
	
	   @GetMapping("test")
//	   @ResponseBody
	    public String test(@RequestParam(value = "name",defaultValue = "zhang")String name) {
	    	ServiceUserImp.serviceTest();
	    	List<UserEntity> findAll = mUserService.findAll();
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
}
