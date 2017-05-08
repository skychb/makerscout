package com.makerscouts.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	
	@Column(nullable = false)
	private String id;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String school;
	
	private String position;

	private User() {
	};

	public User(String id, String password, String name, String school) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.school = school;
	}
}
