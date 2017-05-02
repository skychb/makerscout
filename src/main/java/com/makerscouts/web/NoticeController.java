package com.makerscouts.web;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.Notice;
import com.makerscouts.domain.post.NoticeRepository;

@Controller
@RequestMapping("/notice")
public class NoticeController implements Serializable{
	@Autowired
	private NoticeRepository noticeRepository;
	
	@RequestMapping("")
	public String loadPostPage(){
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
		Notice notice = noticeRepository.findByPid(id);
		model.addAttribute("notice", notice);
		return "show";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String setPost(Notice notice){
		notice.setTimestamp(new Date());
		System.out.println(notice);
		return "redirect:/notice/"+noticeRepository.save(notice).getPid();
	}	
}
