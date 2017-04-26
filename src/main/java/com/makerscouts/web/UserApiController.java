package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@RestController
public class UserApiController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public List<User> createUser(){
		List<User> userList = userRepository.findAll();
		return userList;
	}	
}
