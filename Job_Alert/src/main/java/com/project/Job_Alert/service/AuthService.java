package com.project.Job_Alert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;
import com.project.Job_Alert.exceptionhandling.ApplicationException;
import com.project.Job_Alert.securityconf.JWTUtils;

@Service
public class AuthService implements IAuthService {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtils jwt;
	
	@Autowired
	private  AuthenticationManager authManager;
	
	@Override
	public ResponseEntity<AuthResponse> authenticate(AuthRequest request) {
		AuthResponse response = new AuthResponse();
		try {
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
			String token = jwt.generateToken(userDetails);
			response.setToken(token);
			return ResponseEntity.ok(response);	
		} catch (BadCredentialsException exception){
			throw new ApplicationException(exception.getMessage(), HttpStatus.UNAUTHORIZED);
		} 
	}

}
