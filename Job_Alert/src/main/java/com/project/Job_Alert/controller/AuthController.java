package com.project.Job_Alert.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;
import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.exceptionhandling.ErrorResponse;
import com.project.Job_Alert.repository.UserRepository;
import com.project.Job_Alert.securityconf.JWTUtils;
import com.project.Job_Alert.service.AuthService;
import com.project.Job_Alert.service.IAuthService;
import com.project.Job_Alert.service.IUserService;

@RestController
public class AuthController {

	
	@Autowired 
	private IUserService userService;
	
	@Autowired 
	private IAuthService authService;
	

	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
		return authService.authenticate(request);	
	}
	
	@PostMapping("/signup")
	public Object authenticate1(@RequestBody SignupDTO user) {
			return userService.save(user);
	}
}
