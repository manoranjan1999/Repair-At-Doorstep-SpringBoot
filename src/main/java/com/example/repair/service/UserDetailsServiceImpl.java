package com.example.repair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.repair.model.MyUserDetails;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.User;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	ServiceProviderRepo serviceProviderRepo;

	@Override
	public UserDetails loadUserByUsername(String emailId) {
		Optional<User> user = userRepo.findByEmailId(emailId);
		if (user.isPresent()) {
			return user.map(MyUserDetails::new).get();
		} else {
			Optional<ServiceProvider> serviceProvider = serviceProviderRepo.findByEmailId(emailId);
			return serviceProvider.map(MyUserDetails::new).get();
		}
	}

}
