package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;
import com.makerscouts.domain.user.Team;
import com.makerscouts.domain.user.TeamRepository;
import com.makerscouts.domain.user.User;
import com.makerscouts.domain.user.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String home() {
		return "promotion";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/faq", method=RequestMethod.GET)
	public String faq(){
		return "faq";
	}
	
	@GetMapping(value="/")
	public String realHome(){
		return "index";
	}
	
	@RequestMapping(value="/team/{teamId}", method=RequestMethod.GET)
	public String showTeamPage(@PathVariable int teamId, Model model){
		Team teamList = teamRepository.findById(teamId);
		model.addAttribute("team", teamList);
		return "tile";
	}
	
	@RequestMapping(value="/teampost/{teamId}", method=RequestMethod.GET)
	public String showTeamPost(@PathVariable int teamId, Model model){
		List<Post> teamList = postRepository.findByTeamId(teamId);
		model.addAttribute("post", teamList);
		return "list_team";
	}
	
	@RequestMapping(value="/user/")
	public String view(Model model){
		List<User> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "index";
	}
	
	@RequestMapping(value="/lobby", method=RequestMethod.GET)
	public String lobbyView(Model model){
		List<Post> postList = postRepository.findAll();
		return "lobby";
	}
	
	@GetMapping(value="/admin")
	public String adminLobby(){
		return "lobby_admin";
	}
	
}
