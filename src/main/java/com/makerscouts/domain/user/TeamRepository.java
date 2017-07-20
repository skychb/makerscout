package com.makerscouts.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	Team findById(int id);
}
