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
import com.makerscouts.domain.post.Post;

@Controller
@RequestMapping("/notice")
public class NoticeController implements Serializable{
	@Autowired
	private NoticeRepository noticeRepository;
	
	@RequestMapping("")
	public String loadPostPage(Model model){
		model.addAttribute("type", "notice");
		return "upload";
	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public String addPost(String title, String author, String contents){
//		Post newPost = new Post(title, author, contents);
//		postRepoitory.save(newPost);
//		return "redirect:/post";
//	};
	
	@RequestMapping(value="/edit/{id}")
	public String getPostForEdit(Model model, @PathVariable long id){
		Notice notice = noticeRepository.findOne(id);
		model.addAttribute("notice", notice);
		return "edit_notice";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String putPost(Notice notice, @PathVariable long id){
		Notice fetchNotice = noticeRepository.findOne(id);
		if (fetchNotice == null) {
			return null;
		}
		fetchNotice.setContents(notice.getContents());
		fetchNotice.setTitle(notice.getTitle());
		fetchNotice.setAuthor(notice.getAuthor());
		
		noticeRepository.save(fetchNotice);
		
		return "redirect:/notice/"+Long.toString(fetchNotice.getPid());
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deletePost(Model model, @PathVariable long id){
		Notice post = noticeRepository.findOne(id);
		noticeRepository.delete(post);
		return "redirect:/";
	}
	
	@RequestMapping(value="/{id}")
	public String getPost(Model model, @PathVariable long id){
		Notice notice = noticeRepository.findByPid(id);
		model.addAttribute("post", notice);
		return "show";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String setPost(Notice notice){
		notice.setTimestamp(new Date());
		System.out.println(notice);
		return "redirect:/notice/"+noticeRepository.save(notice).getPid();
	}	
}
