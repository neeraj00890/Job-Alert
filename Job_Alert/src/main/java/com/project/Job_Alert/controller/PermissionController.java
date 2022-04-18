package com.project.Job_Alert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobalert.entity.Permission;
import com.jobalert.repository.PermissionRepository;
import com.project.Job_Alert.dto.ResponseDTO;

@RestController()
@RequestMapping("permissions")
public class PermissionController {

	@Autowired
	private  PermissionRepository permissionRepo;
		@GetMapping() 
		public ResponseEntity<ResponseDTO>  getAllPermissions() {
			ResponseDTO response  = new ResponseDTO();
			Iterable<Permission> permissions = permissionRepo.findAll();
			response.setData(permissions);
			response.setMessage("Permission Changed List");
			return ResponseEntity.ok(response);
		}
}
