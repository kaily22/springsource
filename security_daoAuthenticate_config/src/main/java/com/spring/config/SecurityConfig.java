package com.spring.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.spring.handler.CustomAccessDeniedHandler;
import com.spring.handler.CustomLoginSuccessHandler;
import com.spring.service.CustomUserDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	
	}
	
	@Bean
	public PersistentTokenRepository PersistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
		
	}
	
	@Bean
	public UserDetailsService CustomUserDetailService() {
		return new CustomUserDetailService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//모든 사람이 접근 할 수 있는 url 지정	
		http.authorizeRequests()
			.antMatchers("/login")
			.permitAll();
		
		http.exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler()));
		
		http.formLogin().loginPage("/login").failureUrl("/login-error").successHandler(loginSuccessHandler());
		
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/");
		
		http.rememberMe().tokenRepository(PersistentTokenRepository()).tokenValiditySeconds(604800);
		
		}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(CustomUserDetailService()).passwordEncoder(passwordEncoder());
		
	}
	    
	
	}
