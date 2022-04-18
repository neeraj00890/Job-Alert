package com.project.Job_Alert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobalert.entity.Skill;
import com.jobalert.repository.SkillRepository;

@Service()
public class SkillService implements ISkillService {

	@Autowired
	SkillRepository repository;
	
	@Override
	public Iterable<Skill> findAll(String searchText) {
		if(searchText != "" && searchText != null) return repository.findBySearchText(searchText);
		return repository.findAll();
	}
}
