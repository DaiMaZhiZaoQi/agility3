package org.agility.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sx.agility.service.ServiceUserImp;
import com.sx.agility.service.UserService;
import com.sx.model.entity.UserEntity;

import ch.qos.logback.classic.Logger;


/**
 * Hello world!
 * springBoot 入口类放置的位置很重要
 */
@SpringBootApplication
@RestController
public class App  extends SpringBootServletInitializer {
	
	
	
	/**
	 * 在测试阶段调用
	 * @param args
	 */
    public static void main(String[] args ){
    	SpringApplication.run(App.class,args);
    }
    
    
	/**
	 * 在tomcat中执行调用该方法启动SpringBoot 
	 */
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		  return builder.sources(App.class); 
	}
	 
    
 
    
}
