package com.makerscouts.domain.post;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="post")
public class Post implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	private Timestamp timestamp;
	
	@Column(nullable = false)
	private String contents;
	
	private Post(){};
	
	public Post(String title, String author, String contents){
		
	}
}
