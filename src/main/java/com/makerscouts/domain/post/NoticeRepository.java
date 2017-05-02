package com.makerscouts.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	Notice findByPid(Long pid);
}
