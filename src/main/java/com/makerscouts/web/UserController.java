package com.makerscouts.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/login/form", method = RequestMethod.GET)
	public String accessLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String password, HttpServletRequest request){
		User user = userRepository.findById(id);
		if(password.equals(user.getPassword())){
			request.getSession().setAttribute("user", user);
			return "redirect:/lobby";
		}else{
			return "login_fail";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "index";
	};
}
