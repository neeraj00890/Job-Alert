package com.project.Job_Alert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.project.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
	
	@Query("SELECT user from User as user WHERE user.role.roleName = :roleName")
	public List<User> findByRoleName(@Param("roleName")String roleName);
}
