package com.makerscouts.web;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.News;
import com.makerscouts.domain.post.NewsRepository;
import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;

@Controller
@RequestMapping(value="/post")
public class PostController implements Serializable{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@RequestMapping("")
	public String loadPostPage(Model model){
		model.addAttribute("type", "post");
		return "upload";
	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public String addPost(String title, String author, String contents){
//		Post newPost = new Post(title, author, contents);
//		postRepoitory.save(newPost);
//		return "redirect:/post";
//	};
	
	@RequestMapping(value="/{id}")
	public String getPost(Model model, @PathVariable long id){
		Post post = postRepository.findOne(id);
		model.addAttribute("post", post);
		return "show";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String setPost(Post post, HttpSession session){
		post.setTimestamp(new Date());
		News news = new News(post.getAuthor(), new Date(), post.getTitle());
		newsRepository.save(news);
		return "redirect:/post/"+postRepository.save(post).getPid();
	}	
}
