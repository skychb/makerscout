package com.makerscouts.domain.chat;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Message {
	private String content;

	public Message(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
