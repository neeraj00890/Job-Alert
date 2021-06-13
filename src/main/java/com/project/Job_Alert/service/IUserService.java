package com.project.Job_Alert.service;

import com.project.Job_Alert.dto.SignupDTO;
import com.project.entity.User;

public interface IUserService {

	 User save(SignupDTO user);
	 Iterable<User> getAll();
		
}
