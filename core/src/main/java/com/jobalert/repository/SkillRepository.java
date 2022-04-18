package com.jobalert.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobalert.entity.Skill;


@Repository()
public interface SkillRepository extends CrudRepository<Skill, Long> {

	@Query("SELECT s from Skill s  WHERE s.name LIKE CONCAT('%', :searchText, '%')")
	Iterable<Skill> findBySearchText(@Param("searchText") String searchText);
	
}
