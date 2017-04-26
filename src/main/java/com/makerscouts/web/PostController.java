package com.makerscouts.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;

@Controller
@RequestMapping(value="/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("")
	public String loadPostPage(){
		return "upload";
	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public String addPost(String title, String author, String contents){
//		Post newPost = new Post(title, author, contents);
//		postRepository.save(newPost);
//		return "redirect:/post";
//	};
	
	@RequestMapping(value="/{id}")
	public String getPost(Model model, @PathVariable long id){
		Post post = postRepository.findOne(id);
		model.addAttribute("post", post);
		return "show";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String setPost(Post post){
		post.setTimestamp(new Date());
		System.out.println(post);
		return "redirect:/post/"+postRepository.save(post).getPid();
	}	
}
