package com.project.Job_Alert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.project.entity.*;

import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.exceptionhandling.ApplicationException;
import com.project.Job_Alert.repository.RoleRepository;
import com.project.Job_Alert.repository.UserRepository;
import com.project.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public User save(SignupDTO user) {
		
		User dbUser = new User();
		dbUser.setFirstName(user.getFirstname());
		dbUser.setLastName(user.getLastname());
		dbUser.setPassword(user.getPassword());
		dbUser.setPhoneNo(user.getPhoneNo());
		dbUser.setUsername(user.getUsername());
		dbUser.setEmail(user.getEmail());
		Role userRole = roleRepo.findByRoleName(user.getRole());
		dbUser.setRole(userRole);
		try {
			return userRepo.save(dbUser);
		} catch(Exception e) {
			throw new ApplicationException("Neeraj ka error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<User> findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return userRepo.findByRoleName(roleName);
	}
	
	

}
