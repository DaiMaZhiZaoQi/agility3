package com.agility.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agility.common.Result;
import com.agility.common.aspect.DoneTime;
import com.agility.common.redis.RedisUtils;
import com.agility.dao.DaoRoleMapper;
import com.agility.dao.DaoUserMapper;
import com.agility.model.entity.UserEntity;
import com.agility.service.ServiceUserImp;
import com.agility.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Controller
@RestController
@RequestMapping("/user/")
public class UserController extends BaseController{

	private Logger log=LoggerFactory.getLogger(UserController.class);
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
	   
	   @ResponseBody
	   @RequestMapping("testRedis")
	   public Result testRedis(@RequestParam(value = "name")String name) {
		   RedisUtils.set("name", name);
		   String rName=(String) RedisUtils.get("name");
		   System.out.println("rName--->"+rName);
		   return Result.success();
	   }
	   
	   /**
	    * Nginx，静态资源
	    * @return
	    */
	   public String website() {
		   return "";
	   }
	   
	   /**
	    * 为了提高web引用可用性，以及性能
	    * redis集群,session集群,多数据源，分库分表，读写分离
	    * @param name
	    * @param password
	    * @return
	    */
	   @GetMapping("login")
	   public Result login(@RequestParam(value="name",defaultValue = "zhangsan")String name,
			   			   @RequestParam(value="password",defaultValue = "1111")String password,HttpServletRequest request) {
//		   mUserService.getById(1);
//		   Cookie[] cookie=request.getCookies();
//		   for(Cookie cook:cookie) {
//			   cook.getName();
//		   }
//		   HttpSession session=request.getSession(false);
//		   session.
//		   session.getValue(name)
		   return Result.success();
		   
	   }
	   @DoneTime(param = "hello")
	    @GetMapping("hello")
	    public String hello(@RequestParam(value="name",defaultValue = "zhangsan") String name) throws Exception {
		   try {
			log.info("hello--thread"+Thread.currentThread().getName());
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		   log.info("hello--thread"+Thread.currentThread().getName()+"-param-"+name);
//		   throw new Exception("测试抛异常");
	        return "hello"+name;
	    }
	   
	    @GetMapping("/admin/hello")
	    public String admin() {
	        return "admin";
	    }

	    @GetMapping("/user/hello")
	    public String user() {
	        return "user";
	    }
	   
	   /**
	    * SpringSecurity 拦截控制
	    * @param id
	    * @return
	    */
	   public Result selectUser(@RequestParam(value="id")Long id) {
		   return Result.success();
	   }
	   
}
