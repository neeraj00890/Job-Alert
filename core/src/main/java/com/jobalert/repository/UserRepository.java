package com.jobalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.jobalert.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
	
	@Query("SELECT user from User as user WHERE user.role.roleName = :roleName")
	public List<User> findByRoleName(@Param("roleName")String roleName);
	
	@Query("SELECT count(email) from User as user WHERE user.email = :email")
	public int isEmailExists(@Param("email")String email);
	
	@Query("SELECT count(username) from User as user WHERE user.username = :username")
	public int isUsernameExists(@Param("username")String username);
}
