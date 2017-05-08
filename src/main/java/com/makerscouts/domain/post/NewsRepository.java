package com.makerscouts.domain.post;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long>{
	List<News> findTopOrderByDate(Pageable pageable);
}
