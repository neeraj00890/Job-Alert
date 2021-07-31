package com.project.Job_Alert.service;

import org.springframework.http.ResponseEntity;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;

public interface IAuthService {

	public ResponseEntity<AuthResponse>  authenticate(AuthRequest authReq);
}
