package com.makerscouts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.makerscouts.domain.post.News;
import com.makerscouts.domain.post.NewsRepository;
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
	
	@Autowired
	private NewsRepository newsRepository;
	
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
	
	@GetMapping("/post/list/{team}")
	public List<Post> listSelectedPost(@PathVariable int team){
		List<Post> posts = postRepository.findByTeamId(team);
		return posts;
	}
	
	@GetMapping("/news/list")
	public List<News> listNews(){
//		Pageable pageableTop = new PageRequest(0,10, Direction.ASC, "date");
//		List<News> news = newsRepository.findTopOrderByDate(pageableTop);
		List<News> news = newsRepository.findAll();
		return news;
	}
}
