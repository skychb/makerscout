package com.makerscouts.domain.chat;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class HelloMessage {
	private String name;
	private String id;
	
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
}
