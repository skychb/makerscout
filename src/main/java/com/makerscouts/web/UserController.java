package com.makerscouts.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/login/form")
	public String accessLogin(String a){
		
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String userPassword, HttpServletRequest request){
		User user = userRepository.findById(userId);
		if(userPassword != user.getPassword()){
			return "login";
		}else{
			request.getSession().setAttribute("user", user);
			return "redirect:/lobby";
		}
	}
}
