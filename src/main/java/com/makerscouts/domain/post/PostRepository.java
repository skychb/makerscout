package com.makerscouts.domain.post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
	Post findByAuthor(String author);
}
