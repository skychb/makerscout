package com.makerscouts.web;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makerscouts.domain.post.Share;
import com.makerscouts.domain.post.ShareRepository;

@Controller
@RequestMapping("/share")
public class ShareController implements Serializable{
	@Autowired
	private ShareRepository shareRepository;
	
	@RequestMapping("")
	public String loadPage(){
		return "upload";
	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public String addPost(String title, String author, String contents){
//		Post newPost = new Post(title, author, contents);
//		postRepoitory.save(newPost);
//		return "redirect:/post";
//	};
	
	@RequestMapping(value="/{id}")
	public String getShare(Model model, @PathVariable long id){
		Share share = shareRepository.findByPid(id);
		model.addAttribute("share", share);
		return "show";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String setShare(Share share){
		share.setTimestamp(new Date());
		System.out.println(share);
		return "redirect:/share/"+shareRepository.save(share).getPid();
	}	
}
