package com.agility;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agility.model.entity.UserEntity;
import com.sx.agility.service.ServiceUserImp;
import com.sx.agility.service.UserService;

import ch.qos.logback.classic.Logger;


/**
 * Hello world!
 * springBoot 入口类放置的位置很重要
 */
@SpringBootApplication
@ComponentScan("com.agility.*")	// TODO 随着项目的增长，包扫描应该有范围限制
//@RestController
public class App /* extends SpringBootServletInitializer */ {
	
	
	
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
//	@Override 
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
//		  return builder.sources(App.class); 
//	}
//	 
    
 
    
}
