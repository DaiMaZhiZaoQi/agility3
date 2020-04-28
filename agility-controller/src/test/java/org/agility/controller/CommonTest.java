package org.agility.controller;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonTest {

	
	  @Test
	    public void contextLoads() {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        System.out.println(encoder.encode("123"));
	    }
	
}
