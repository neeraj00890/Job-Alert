package com.project.Job_Alert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;
import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.service.IAuthService;
import com.project.Job_Alert.service.IHibernatePersistanceService;
import com.project.Job_Alert.service.IUserService;
import com.project.entity.Permission;

@RestController
public class AuthController {

	
	@Autowired 
	private IUserService userService;
	
	@Autowired 
	private IAuthService authService;
	
	@Autowired
	IHibernatePersistanceService persistanceService;
	
	

	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
		return authService.authenticate(request);	
	}
	
	@PostMapping("/signup")
	public Object authenticate1(@RequestBody SignupDTO user) {
			return userService.save(user);
	}
}
