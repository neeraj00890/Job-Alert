package com.project.Job_Alert.securityconf;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobalert.entity.User;
import com.jobalert.repository.UserRepository;
import com.project.Job_Alert.exceptionhandling.ApplicationException;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new ApplicationException("Username is invalid", HttpStatus.UNAUTHORIZED);
		}
		return MyUserDetails.build(user);
	}

}
