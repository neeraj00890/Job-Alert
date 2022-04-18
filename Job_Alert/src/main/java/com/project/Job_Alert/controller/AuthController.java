package com.project.Job_Alert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Job_Alert.dto.AuthRequest;
import com.project.Job_Alert.dto.AuthResponse;
import com.project.Job_Alert.dto.ResponseDTO;
import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.exceptionhandling.ApplicationException;
import com.project.Job_Alert.service.IAuthService;
import com.project.Job_Alert.service.IHibernatePersistanceService;
import com.project.Job_Alert.service.IUserService;

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
	public ResponseEntity<ResponseDTO> signup(@RequestBody SignupDTO user) {
		try {
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setData(userService.save(user));
			responseDTO.setMessage("User register successfully.");
			return ResponseEntity.ok(responseDTO);
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage() != null ? e.getMessage() : "Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/email-exists")
	public ResponseEntity<Object> isEmailExists(@RequestParam String email) {
		ResponseDTO response = new ResponseDTO();
		response.setMessage("email exists response");
		response.setData(userService.isEmailExists(email));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/username-exists")
	public ResponseEntity<Object> isUsernameExists(@RequestParam String username) {
		ResponseDTO response = new ResponseDTO();
		response.setMessage("username exists response");
		response.setData(userService.isUsernameExists(username));
		return ResponseEntity.ok(response);
	}
}
