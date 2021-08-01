package com.project.Job_Alert.securityconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private  PasswordEncoder passwordEncder;
	
	@Autowired
	private MyUserDetailService userDetailsService; 
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthEntryPoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/", "/*.js", "/*.js.map","/*.css", "/*.ico", "/signup", "/authenticate")
		.permitAll()
		.anyRequest()
		.authenticated()
//		.and()
//		.exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//.and()
		//.httpBasic();
		//.formLogin()
		//.loginPage("/").permitAll();
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
		
	@Bean
	public 	AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
