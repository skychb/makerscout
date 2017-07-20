package com.makerscouts.domain.post;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.makerscouts.domain.user.Team;

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
	
	@Column
	private Date timestamp;
	
	@Column
	private Date updated;
	
	@Column(nullable = false, length=100000000)
	private String contents;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="team_id"))
	private Team team;
	
	@Column(name="team_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Integer teamId;
	
	private Post(){};
	
	public Post(String title, String author, String contents, int teamId){
		
	}
}
