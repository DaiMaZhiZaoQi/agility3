package com.sx.common;

import org.junit.Test;

import com.agility.common.HelloMaven;


public class HelloTest {

	
	@Test
	public void testMaven(){
		HelloMaven helloMaven = new HelloMaven();
		String testMaven = helloMaven.testMaven("testMaven"); 
//		Assert.assertEquals("test", testMaven);
	}
	/**
	 * maven生命周期测试
	 */
	@Test
	public void testMaven2() {
		HelloMaven helloMaven = new HelloMaven();
		String testMaven = helloMaven.testMaven("testMaven"); 
//		Assert.assertEquals("test2", testMaven);
	}
	
}
