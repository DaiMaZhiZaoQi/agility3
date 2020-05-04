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

	/**
	 * 环绕增强,参数必须有ProceedingJoinPoint,必须返回joinPoint.proceed()
	 * @param joinPoint
	 * @param doneTime
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(doneTime)")
	public Object around(ProceedingJoinPoint joinPoint,DoneTime doneTime) throws Throwable {
		String param=doneTime.param();
		System.out.println("begin-->"+new Date()+"param-->"+param);
		Object o=joinPoint.proceed();
		System.out.println("end-->"+new Date());
		return o;
	}
}
