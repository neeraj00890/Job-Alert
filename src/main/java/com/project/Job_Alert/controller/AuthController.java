package com.project.Job_Alert.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;
import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.repository.UserRepository;
import com.project.Job_Alert.securityconf.JWTUtils;
import com.project.Job_Alert.service.IUserService;

@RestController
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtils jwt;
	
	@Autowired
	private  AuthenticationManager authManager;
	
	@Autowired 
	private IUserService userService;
	

	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException exception){
			System.out.print(exception);
		} 
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = jwt.generateToken(userDetails);
		AuthResponse response = new AuthResponse();
		response.setToken(token);
		return ResponseEntity.ok(response);		
	}
	
	@PostMapping("/signup")
	public Object authenticate1(@RequestBody SignupDTO user) {
			return userService.save(user);
	}
}
