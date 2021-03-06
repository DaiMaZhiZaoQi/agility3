package com.agility.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.agility.common.CustomAuthenticationFilter;
import com.agility.common.Result;
import com.agility.service.imp.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * SpringSecurity 权限配置, 权限管理基于过滤器实现的
 * @author williambai
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserServiceImp mUserService;
	
	/**
	 * 密码加密
	 * @return
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();   
//		return NoOpPasswordEncoder.getInstance();
	}

//	  	@Bean
//	    RoleHierarchy roleHierarchy() {
//	        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
//	        hierarchy.setHierarchy("super > admin");
//	        return hierarchy;
//	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(mUserService);//.passwordEncoder(new BCryptPasswordEncoder());
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
	    }
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication().withUser("zhangsan").
//		  password("$2a$10$TMnSvwGXfeE4Lpgny5VUYuZPcDhHMcNfxZ91f3k6TfUIJIk.QvKN.").roles("user");
//		  
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated()
//        .and()
//        .formLogin()
//        .and().csrf().disable();
//		http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.authorizeRequests()
//        .antMatchers("/admin/**").hasRole("admin")
//        .antMatchers("/user/**").hasRole("super")
//		.antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginProcessingUrl("/doLogin")
        .successHandler((req, resp, authentication) -> {
            Object principal = authentication.getPrincipal();
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            System.out.println("out-->"+out.toString());
            out.write(new ObjectMapper().writeValueAsString(principal));
            out.flush();
            out.close();
        })
        .failureHandler((req, resp, e) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write(e.getMessage());
            System.out.println("out-->"+e.getMessage());
            out.flush();
            out.close();
        })
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessHandler((req, resp, authentication) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("注销成功");
            out.flush();
            out.close();
        })
        .permitAll()
        .and()
        .csrf().disable().exceptionHandling()
        .authenticationEntryPoint((req, resp, authException) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("尚未登录，请先登录");
                    out.flush();
                    out.close();
                }
        );
	}
	
	@Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                HttpSession session = req.getSession();
//                req.getServletContext().getRealPath(path)
                session.getValue("");
                session.getAttribute("");
                Result respBean = Result.success();
                out.write(new ObjectMapper().writeValueAsString(respBean));
               
                out.flush();
                out.close();
            }
        });
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                Result respBean = Result.error();
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
	
	
	
	

}
