package com.project.Job_Alert.securityconf;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private final List<? extends GrantedAuthority> grantedAuths;
	private final String username;
	private final String password;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isCredentialNonExpired;
	private final boolean isEnabled;
	
	public MyUserDetails(List<? extends GrantedAuthority> grantedAuths, 
			String username, 
			String password,
			boolean isAccountNonExpired, 
			boolean isAccountNonLocked,
			boolean isCredentialNonExpired,
			boolean isEnabled) {
		super();
		this.grantedAuths = grantedAuths;
		this.username = username;
		this.password = password;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialNonExpired = isCredentialNonExpired;
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.grantedAuths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.isCredentialNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isEnabled;
	}

}
