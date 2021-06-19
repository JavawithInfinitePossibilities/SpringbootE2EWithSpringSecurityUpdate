/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sid.e2e.springboot.FlightReservation.controllers.UsersController;

/**
 * @author Lenovo
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/showReg", "/", "index.html", "/registerUser", "/showLogin","/login", "/login/*", "/reservations/*")
			.permitAll()
			.antMatchers("/admin/showAddFlight").hasAnyRole("ADMIN")
			.antMatchers("/admin/superShowAddFlight").hasAnyRole("SUPER")
			.anyRequest().authenticated()
			.and().csrf().disable();
	}

}
