package com.agility.common.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface DoneTime {
	String param() default "";
}
