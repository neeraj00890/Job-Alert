package com.project.Job_Alert.eventlistener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jobalert.entity.Permission;
import com.jobalert.entity.Role;
import com.jobalert.entity.Skill;
import com.jobalert.repository.RoleRepository;
import com.jobalert.repository.SkillRepository;

@Component
public class OnApplicationStartUp {

	
	@Value("${app.forceMode}")
	boolean isForceMode;
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	SkillRepository skillRepo;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(isForceMode) {
			initalizeAdminPerms();
			initalizeStudentPerms();
			initalizeSkillSet();
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
	
	private void initalizeSkillSet() {
		Skill skill1 = new Skill();
		skill1.setName("Java");
		skill1.setDescription("Java is OOPS Languange");
		
		Skill skill2 = new Skill();
		skill2.setName("JavaScript");
		skill2.setDescription("JavaScript is OOPS Languange");
		
		Skill skill3 = new Skill();
		skill3.setName("C++");
		skill3.setDescription("C++ is OOPS Languange");
		
		Skill skill4 = new Skill();
		skill4.setName("Node");
		skill4.setDescription("NodeJs is Backend Scripting Language");
		skillRepo.save(skill1);
		skillRepo.save(skill2);
		skillRepo.save(skill3);
		skillRepo.save(skill4);
	}
}
