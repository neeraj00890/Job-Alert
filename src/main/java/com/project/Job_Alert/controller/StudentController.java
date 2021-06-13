package com.project.Job_Alert.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {
	
static List<String> STUDNETS = new ArrayList<String>();
	
	static {
		STUDNETS.add("STUDNET1");
		STUDNETS.add("STUDNET2");
		STUDNETS.add("STUDNET3");
		STUDNETS.add("STUDNET4");
		STUDNETS.add("STUDNET5");
	}
	@GetMapping
	public  ResponseEntity<List<String>> getAdminDetails() {
		return ResponseEntity.ok(STUDNETS);
	}
	
	@PutMapping
	public  ResponseEntity<List<String>> putAdminDetails(@RequestBody String studentName) {
		System.out.println("Putting studentName...."+ studentName);
		return ResponseEntity.ok(STUDNETS);
	}
	
	@PostMapping
	public  ResponseEntity<List<String>> postAdminDetails(@RequestBody String studentName) {
		STUDNETS.add(studentName);
		return ResponseEntity.ok(STUDNETS);
	}
	
	@DeleteMapping("{studentName}")
	public  ResponseEntity<List<String>> deleteAdminDetails(@PathVariable("studentName") String studentName) {
		STUDNETS =	STUDNETS.stream().filter((admin)-> !admin.equalsIgnoreCase(studentName)).collect(Collectors.toList());
		return ResponseEntity.ok(STUDNETS);
	}

}
