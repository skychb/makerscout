package com.makerscouts.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.makerscouts.domain.post.News;
import com.makerscouts.domain.post.NewsRepository;
import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@GetMapping("/admin/login")
	public String accessAdminLogin(){
		return "login_admin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String accessLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String password, HttpServletRequest request){
		User user = userRepository.findById(id);
		if(password.equals(user.getPassword())){
			request.getSession().setAttribute("user", user);
			News news = new News(user.getName(), new Date(), null);
			newsRepository.save(news);
			return "redirect:/lobby";
		}else{
			return "login_fail";
		}
	}
	
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String admin_login(@RequestParam String id, @RequestParam String password, HttpServletRequest request){
		User user = userRepository.findById(id);
		if(password.equals(user.getPassword()) && user.getPosition().equals("admin")){
			return "redirect:/admin/lobby";
		}
		return "login_fail_admin";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "index";
	};
}
