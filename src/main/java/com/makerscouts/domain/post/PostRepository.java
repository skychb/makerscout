package com.makerscouts.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
	Post findByAuthor(String author);
	Post findByPid(Long pid);
}
