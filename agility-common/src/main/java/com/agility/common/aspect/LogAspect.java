package com.agility.common.aspect;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 日志切面
 * JoinPoint包含了类名，被切面的方法名，参数等信息
 * @author williambai
 *
 */
@Aspect
@Component
public class LogAspect {
	private static Logger log=LoggerFactory.getLogger(LogAspect.class);
	
	
	// 定义切点
	@Pointcut("execution(public * com.agility.controller.*.*(..))")
	public void logAspect() {}
	
	@Before("logAspect()")
	public void before(JoinPoint joinPoint) {
			Signature signature = joinPoint.getSignature();
			String name = signature.getName(); 
			log.info("before-->"+name);
	}
	
	@After("logAspect()")
	public void afeter(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		log.info("after-->"+name);
	}
	
	
	@AfterReturning("logAspect()")
	public void afterReturn(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for(Object obj:args) {
			log.info("afterReturn-->"+obj.toString());
		}
	} 
	
	/**
	 * 抛异常时
	 * @param joinPoint
	 */
	@AfterThrowing("logAspect()")
	public void afterThrowing(JoinPoint joinPoint) {
		log.info("--afterThrowing--");
	}
	
	/**
	 * 环绕增强  参数类型必须为 proceedjoinPoint类型
	 * @param proceedjoinPoint
	 * @throws Throwable 
	 */
	@Around("logAspect()")
	public Object around(ProceedingJoinPoint proceedjoinPoint) throws Throwable{
		log.info("--around1--");
			 Object obj=proceedjoinPoint.proceed();
		log.info("--around2--");
		return obj;
	}
//	
	
}
