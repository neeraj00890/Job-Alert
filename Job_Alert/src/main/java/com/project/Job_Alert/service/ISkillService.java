package com.project.Job_Alert.service;

import com.jobalert.entity.Skill;

public interface ISkillService {
	
	Iterable<Skill> findAll(String searchText);
}
