package com.makerscouts.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	protected void configure(AuthenticationManagerBuilder amb) throws Exception{
		
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers().permitAll();
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**")
				.permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/share/**").authenticated().antMatchers("/share")
//				.access("hasRole(ROLE_USER)").anyRequest().permitAll().and().formLogin().loginPage("/login")
//				.loginProcessingUrl("/login").permitAll().and().logout().permitAll();
//		http.httpBasic();
//		http.authorizeRequests().antMatchers("/project").anonymous().antMatchers(HttpMethod.GET, "/").authenticated()
//				.and().formLogin().loginPage("/loginform").loginProcessingUrl("/users/login").failureUrl("/login")
//				.usernameParameter("userId").passwordParameter("password").defaultSuccessUrl("/project").and().logout()
//				.logoutSuccessUrl("/");
//		http.authorizeRequests().antMatchers("/post/list");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
}
