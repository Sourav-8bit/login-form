package com.loginForm.loginForm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan("com.concretepage")
public class LoginConfig extends WebSecurityConfigurerAdapter{

	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
		.authorizeRequests().antMatchers("/sendmail").hasRole("ADMIN").
		and().formLogin()
		.and().csrf().disable();
		
	
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
		 auth.inMemoryAuthentication().withUser("ram").password("{noop}ram123").roles("ADMIN");
	}
	

	
}
