package com.project.Job_Alert.controller;

import java.util.ArrayList;
import java.util.List;

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

@RequestMapping("/api/admin")
@RestController
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	static List<String> ADMIN_LIST = new ArrayList<String>();
	
	static {
		ADMIN_LIST.add("ADMIN1");
		ADMIN_LIST.add("ADMIN2");
		ADMIN_LIST.add("ADMIN3");
		ADMIN_LIST.add("ADMIN4");
		ADMIN_LIST.add("ADMIN5");
	}
	@GetMapping
	
	public  ResponseEntity<List<String>> getAdminDetails() {
		return ResponseEntity.ok(ADMIN_LIST);
	}
	
	@PutMapping
	public  ResponseEntity<List<String>> putAdminDetails(@RequestBody String adminName) {
		System.out.println("Putting admin...."+ adminName);
		return ResponseEntity.ok(ADMIN_LIST);
	}
	
	@PostMapping
	public  ResponseEntity<List<String>> postAdminDetails(@RequestBody String adminName) {
		ADMIN_LIST.add(adminName);
		return ResponseEntity.ok(ADMIN_LIST);
	}
	
	@DeleteMapping("{adminName}")
	public  ResponseEntity<List<String>> deleteAdminDetails(@PathVariable("adminName") String adminName) {
		ADMIN_LIST.stream().map((admin)-> {
			if(admin == adminName) {
				return "";
			}
			return admin;
		});
		return ResponseEntity.ok(ADMIN_LIST);
	}
}
