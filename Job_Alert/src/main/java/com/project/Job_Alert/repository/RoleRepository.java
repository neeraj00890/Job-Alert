package com.project.Job_Alert.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.Role;
import com.project.entity.User;

public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByRoleName(String roleName);
}
