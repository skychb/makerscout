package com.makerscouts.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/user/")
	public String view(Model model){
		List<User> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "index";
	}
	
}
