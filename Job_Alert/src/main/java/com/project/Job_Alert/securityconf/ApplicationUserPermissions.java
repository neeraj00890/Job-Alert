package com.project.Job_Alert.securityconf;

public enum ApplicationUserPermissions {

	COUSRSE_READ("course:read"),
	COURSE_WRITE("course:write"),
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write");
	
	private final String permissions;
	 private ApplicationUserPermissions(String permission) {
		this.permissions = permission;
	}
	 
	 public String getPermissions() {
		 return permissions;
	 }
}
