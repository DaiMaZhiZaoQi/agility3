package org.agility.controller;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonTest {

	
	  @Test
	    public void contextLoads() {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String encode = encoder.encode("111111"); 
	        System.out.println(encode);
	        boolean matches = encoder.matches("111111", encode);
	        System.out.println("matches-->"+matches); 
	    }
	
}
