package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.user.Team;
import com.makerscouts.domain.user.TeamRepository;

@RestController
public class TeamApiController {
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/team/list")
	public List<Team> listTeam(){
		List<Team> teams = teamRepository.findAll();
		return teams;
	}

}
