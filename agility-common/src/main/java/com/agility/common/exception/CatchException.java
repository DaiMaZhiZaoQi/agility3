package com.agility.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.agility.common.ResponseCode;
import com.agility.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 异常处理
 * @author williambai
 *
 */
@Component
public class CatchException implements HandlerExceptionResolver{
	
	private static Logger log=  LoggerFactory.getLogger(CatchException.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String string = (String) headerNames.nextElement();
			log.info("resolveException---"+string);
		}
//		ModelAndView modelAndView = new ModelAndView();
	
//		try {
//			PrintWriter writer = response.getWriter();
//			Result error = Result.error();
//			ObjectMapper objectMapper = new ObjectMapper();   
//			String json = objectMapper.writeValueAsString(error);
//			writer.write(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
		modelAndView.addObject("result",ResponseCode.err.getCode());
		return modelAndView;
	}

}
