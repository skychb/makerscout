package com.makerscouts.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;

@RestController
public class PostApiController {
	@Autowired
	private PostRepository postRepository;
	
//	@RequestMapping(value="/post/add", method=RequestMethod.POST)
//	public Post addPost(String author, String contents, String title){
//		Post newPost = new Post(title, author, contents);
//		postRepository.save(newPost);
//		return newPost;
//	}
//
//	@RequestMapping(value="/post", method=RequestMethod.GET)
//	public @ResponseBody Iterable<Post> list(){
//		return postRepository.findAll();
//	}
}
