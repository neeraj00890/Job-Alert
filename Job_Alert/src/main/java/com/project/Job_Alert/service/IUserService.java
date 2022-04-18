package com.project.Job_Alert.service;

import java.util.List;

import com.jobalert.entity.User;
import com.project.Job_Alert.dto.SignupDTO;

public interface IUserService {

	 User save(SignupDTO user);
	 Iterable<User> getAll();
	 List<User> findByRoleName(String roleName);
	 boolean isEmailExists(String email);
	 boolean isUsernameExists(String username);
	 
		
}
