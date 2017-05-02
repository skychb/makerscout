package com.makerscouts.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long>{
	Share findByPid(Long pid);
}
