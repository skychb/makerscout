package com.makerscouts.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.makerscouts.domain.chat.HelloMessage;
import com.makerscouts.domain.chat.Message;
import com.nhncorp.lucy.security.xss.XssSaxFilter;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(HelloMessage message) throws Exception {
		XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-servlet-filter-rule.xml");
		String clean = filter.doFilter(message.getName());
		return new Message(message.getId() +" : "+ clean+ "\n\r");
    }	
}