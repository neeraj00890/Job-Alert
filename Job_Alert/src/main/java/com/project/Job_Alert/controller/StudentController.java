package com.project.Job_Alert.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jobalert.entity.User;
import com.project.Job_Alert.dto.ResponseDTO;
import com.project.Job_Alert.service.IUserService;

@RestController
@RequestMapping("/api/students")
@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMIN')")
public class StudentController {

	@Autowired
	private IUserService userService;

	static List<String> STUDNETS = new ArrayList<String>();

	static {
		STUDNETS.add("STUDNET1");
		STUDNETS.add("STUDNET2");
		STUDNETS.add("STUDNET3");
		STUDNETS.add("STUDNET4");
		STUDNETS.add("STUDNET5");
	}

	@PutMapping
	@PreAuthorize("hasAuthority('std:write')")
	public ResponseEntity<List<String>> putAdminDetails(@RequestBody String studentName) {
		System.out.println("Putting studentName...." + studentName);
		return ResponseEntity.ok(STUDNETS);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('std:write')")
	public ResponseEntity<List<String>> postAdminDetails(@RequestBody String studentName) {
		STUDNETS.add(studentName);
		return ResponseEntity.ok(STUDNETS);
	}

	@DeleteMapping("{studentName}")
	@PreAuthorize("hasAuthority('std:write')")
	public ResponseEntity<List<String>> deleteAdminDetails(@PathVariable("studentName") String studentName) {
		STUDNETS = STUDNETS.stream().filter((admin) -> !admin.equalsIgnoreCase(studentName))
				.collect(Collectors.toList());
		return ResponseEntity.ok(STUDNETS);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('std:read')")
	public ResponseEntity<ResponseDTO> getStudents() {
		List<User> users = userService.findByRoleName("ROLE_STUDENT");
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setData(users);
		responseDTO.setMessage("student list.");
		return ResponseEntity.ok(responseDTO);
	}

}
