package com.example.repair.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class MyUserDetails implements UserDetails{


	private static final long serialVersionUID = 1L;
	String emailId;
	String password;
	List<GrantedAuthority> authority;
	
	
	public MyUserDetails(User user) {
		this.emailId=user.getEmailId();
		this.password=user.getPassword();
		this.authority=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());	
	}
	public MyUserDetails(ServiceProvider serviceProvider) {
		this.emailId=serviceProvider.getEmailId();
		this.password=serviceProvider.getPassword();
		
		this.authority=Arrays.stream(serviceProvider.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());	
	}
	public MyUserDetails() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authority;
		
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		return emailId;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
