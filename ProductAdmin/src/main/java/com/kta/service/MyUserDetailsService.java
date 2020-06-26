package com.kta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kta.model.MyUserDetails;
import com.kta.model.User;
import com.kta.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User>user=userRepository.findByuserName(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found"));	
		return user.map(MyUserDetails::new).get();
	}

}
