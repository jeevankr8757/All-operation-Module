package com.pro.config;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.pro.model.UserDemo;
import com.pro.repository.UserRepository;

@Service
//@RequiredArgsConstructor
public class MyUserConfig implements UserDetailsService {

	@Autowired
	private  UserRepository userRepo ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    UserDemo user = userRepo.findByEmail(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username));

	    // Ensure the role is prefixed with ROLE_
//	    String role = user.getRole().startsWith("ROLE_") ? user.getRole() : "ROLE_" + user.getRole();
	    List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

	    return new User(user.getEmail(), user.getPassword(), authorities);
	}


}
