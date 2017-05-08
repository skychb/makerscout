package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;
import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PostRepository postRepostory;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/team", method=RequestMethod.GET)
	public String showTeamPage(){
		return "tile";
	}
	
	@RequestMapping(value="/user/")
	public String view(Model model){
		List<User> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "index";
	}
	
	@RequestMapping(value="/lobby", method=RequestMethod.GET)
	public String lobbyView(Model model){
		List<Post> postList = postRepostory.findAll();
		return "lobby";
	}
	
	@GetMapping(value="/admin/lobby")
	public String adminLobby(){
		return "lobby_admin";
	}
	
}
