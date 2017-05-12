package com.makerscouts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.makerscouts.domain.user.UserRepository;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.makerscouts.domain.user.User user = userRepository.findById(username);
		if (user == null) {
			throw new UsernameNotFoundException("");
		}
		
		java.util.List<GrantedAuthority> authorities = buildUserAuthority();
		return buildUserForAuthentication(user, authorities);
	}
	// 권한 내용을 정의하고 이를 적용하는 파트.
	
	private User buildUserForAuthentication(com.makerscouts.domain.user.User user, java.util.List<GrantedAuthority> authorities) {
		return new User(user.getId(), user.getPassword(),
				true, true, true, true, authorities);
	}
		
	
	private java.util.List<GrantedAuthority> buildUserAuthority() {
		java.util.List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authorities;
	}
}
