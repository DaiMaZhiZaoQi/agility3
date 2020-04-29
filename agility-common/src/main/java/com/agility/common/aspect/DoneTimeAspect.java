package com.agility.common.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author williambai
 *
 */
@Aspect
@Component
public class DoneTimeAspect {

	
	@Around("@annotation(doneTime)")
	public Object around(ProceedingJoinPoint joinPoint,DoneTime doneTime) throws Throwable {
		String param=doneTime.param();
		System.out.println("begin-->"+new Date()+"param-->"+param);
		Object o=joinPoint.proceed();
		System.out.println("end-->"+new Date());
		return o;
	}
}
