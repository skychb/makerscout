package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.post.Notice;
import com.makerscouts.domain.post.NoticeRepository;
import com.makerscouts.domain.post.Post;
import com.makerscouts.domain.post.PostRepository;
import com.makerscouts.domain.post.Share;
import com.makerscouts.domain.post.ShareRepository;

@RestController
public class PostApiController {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private ShareRepository shareRepository;
	
	@GetMapping("/post/list")
	public List<Post> listPost(){
		List<Post> posts = (List<Post>) postRepository.findAll();
		return posts;
	}
	
	@GetMapping("/notice/list")
	public List<Notice> listNotice(){
		List<Notice> notices = noticeRepository.findAll();
		return notices;
	}
	
	@GetMapping("/share/list")
	public List<Share> listShare(){
		List<Share> shares = shareRepository.findAll();
		return shares;
	}
	
	
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
