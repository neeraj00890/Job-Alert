package com.project.Job_Alert.service;

import java.util.List;

import com.project.Job_Alert.dto.SignupDTO;
import com.project.entity.User;

public interface IUserService {

	 User save(SignupDTO user);
	 Iterable<User> getAll();
	 List<User> findByRoleName(String roleName);
		
}
