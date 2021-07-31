package com.project.Job_Alert.eventlistener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.project.Job_Alert.repository.RoleRepository;
import com.project.entity.Permission;
import com.project.entity.Role;

@Component
public class OnApplicationStartUp {

	
	@Value("${app.forceMode}")
	boolean isForceMode;
	@Autowired
	RoleRepository roleRepo;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(isForceMode) {
			initalizeAdminPerms();
			initalizeStudentPerms();
		}
	}

	private void initalizeAdminPerms() {
		Role role = new Role();
		Permission COURSE_READ = new Permission();
		Permission COURSE_WRITE = new Permission();
		Permission STUDENT_READ = new Permission();
		Permission STUDENT_WRITE = new Permission();
		COURSE_READ.setPermisssionName("course:read");
		COURSE_WRITE.setPermisssionName("course:write");
		STUDENT_READ.setPermisssionName("std:read");
		STUDENT_WRITE.setPermisssionName("std:write");
		List<Permission> adminPerms = new ArrayList<Permission>() {
			{
				add(COURSE_READ);
				add(COURSE_WRITE);
				add(STUDENT_READ);
				add(STUDENT_WRITE);

			}
		};

		role.setPermissions(adminPerms);
		role.setRoleName("ROLE_ADMIN");
		roleRepo.save(role);
	}

	private void initalizeStudentPerms() {
		Permission COURSE_READ = new Permission();
		Permission STUDENT_READ = new Permission();
		COURSE_READ.setPermisssionName("course:read");
		STUDENT_READ.setPermisssionName("std:read");
		Role role = new Role();
		List<Permission> stdPerms = new ArrayList<Permission>() {
			{
				add(COURSE_READ);
				add(STUDENT_READ);
			}
		};

		role.setPermissions(stdPerms);
		role.setRoleName("ROLE_STUDENT");
		roleRepo.save(role);
	}
}
