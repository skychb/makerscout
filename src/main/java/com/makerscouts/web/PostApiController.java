package com.makerscouts.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;

@RestController
public class PostApiController {
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/post/add")
	public Post addPost(String author, String contents, String title){
		Post newPost = new Post(title, author, contents);
		postRepository.save(newPost);
		
		return newPost;
	}
}
