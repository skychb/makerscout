package com.makerscouts.domain.post;

import java.io.Serializable;
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
@Table(name="share")
public class Share implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column
	private Date timestamp;
	
	@Column
	private Date updated;
	
	@Column(nullable = false, length=100000000)
	private String contents;
	
	private Share(){};
	
	public Share(String title, String author, String contents){
		
	}
}
