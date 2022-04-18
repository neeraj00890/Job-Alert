package com.project.Job_Alert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobalert.core.CommonUtil;
import com.project.Job_Alert.dto.ResponseDTO;
import com.project.Job_Alert.service.ISkillService;

@RestController
@RequestMapping("skills")
public class SkillController {
	
	@Autowired
	ISkillService skillService;
	
	@GetMapping()
	public ResponseEntity<ResponseDTO> fetchAll(@RequestParam String searchText) {
		ResponseDTO res = new ResponseDTO();
		CommonUtil.printMe();
		res.setData(skillService.findAll(searchText));
		res.setMessage("Skill list");
		return ResponseEntity.ok(res);
	}

}
