package com.project.Job_Alert.securityconf;

import java.util.Set;
import java.util.HashSet;

public class ApplicationUserRole {
	private static   Set<ApplicationUserPermissions> adminPermissions = new HashSet<ApplicationUserPermissions>();
	static {
		adminPermissions.add(ApplicationUserPermissions.COURSE_WRITE);
		adminPermissions.add(ApplicationUserPermissions.STUDENT_READ);
		adminPermissions.add(ApplicationUserPermissions.COUSRSE_READ);
		adminPermissions.add(ApplicationUserPermissions.STUDENT_WRITE);
	}

	public enum ADMIN {
		ADMIN(adminPermissions);
		private  Set<ApplicationUserPermissions> userPermissions;
		
		ADMIN(Set<ApplicationUserPermissions> userPermissions) {
			this.userPermissions = userPermissions;
		}
		
		public  Set<ApplicationUserPermissions> getPermissions() {
			return this.userPermissions;
		}
	}
	
	public enum STUDENT {
		STUDENT
	}
	
	
}
