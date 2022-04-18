package com.project.Job_Alert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jobalert.entity.Role;
import com.jobalert.entity.Skill;
import com.jobalert.entity.User;
import com.jobalert.repository.RoleRepository;
import com.jobalert.repository.SkillRepository;
import com.jobalert.repository.UserRepository;
import com.project.Job_Alert.dto.SignupDTO;
import com.project.Job_Alert.exceptionhandling.ApplicationException;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private SkillRepository skillRepo;

	@Override
	public User save(SignupDTO user) {
		if (isEmailExists(user.getEmail()))
			throw new ApplicationException("Email already exists", HttpStatus.NOT_ACCEPTABLE);

		if (isUsernameExists(user.getUsername()))
			throw new ApplicationException("Username already exists", HttpStatus.NOT_ACCEPTABLE);

		User dbUser = new User();
		dbUser.setFirstName(user.getFirstname());
		dbUser.setLastName(user.getLastname());
		dbUser.setPassword(user.getPassword());
		dbUser.setPhoneNo(user.getPhoneNo());
		dbUser.setUsername(user.getUsername());
		dbUser.setEmail(user.getEmail());
		user.getSkill().stream().forEach((skill) -> {
			Skill dbSkill = skillRepo.findById(skill.getId()).get();
			dbUser.getSkills().add(dbSkill);
		});
		dbUser.setSkills(user.getSkill());
		Role userRole = roleRepo.findByRoleName(user.getRole());
		dbUser.setRole(userRole);
		try {
			return userRepo.save(dbUser);
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Iterable<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public List<User> findByRoleName(String roleName) {
		return userRepo.findByRoleName(roleName);
	}

	@Override
	public boolean isEmailExists(String email) {
		int count = userRepo.isEmailExists(email);
		if (count > 0) {
			throw new ApplicationException("Email already exists", HttpStatus.NOT_ACCEPTABLE);
		}
		;
		return false;
	}

	@Override
	public boolean isUsernameExists(String username) {
		int count = userRepo.isUsernameExists(username);
		if (count > 0) {
			throw new ApplicationException("Username already exists", HttpStatus.NOT_ACCEPTABLE);
		}
		return false;
	}

}
