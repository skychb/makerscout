package com.makerscouts.domain.post;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="news")
public class News implements Serializable{
	@Id
	@GeneratedValue
	private long pid;
	
	@Column(nullable=false)
	private String id;
	
	@Column(nullable=false)
	private Date date;
	
	private String title;
	
	public News(){};
	
	public News(String id, Date date, String title){
		this.id = id;
		this.date = date;
		this.title = title;
	}
}
