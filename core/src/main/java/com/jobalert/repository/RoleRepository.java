package com.jobalert.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobalert.entity.Role;



public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByRoleName(String roleName);
}
