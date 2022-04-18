package com.project.Job_Alert.dto;

import java.util.List;

import com.jobalert.entity.Skill;



public class SignupDTO {
	
	private String username;
	private String password;
	private String phoneNo;
	private String firstname;
	private String lastname;
	private String email;
	private String role;
	private List<Skill> skills;
	public String getRole() {
		return role;
	}
	public List<Skill> getSkill() {
		return skills;
	}
	public void setSkill(List<Skill> skill) {
		this.skills = skill;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
