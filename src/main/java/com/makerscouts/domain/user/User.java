package com.makerscouts.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_user_parent_id"))
	private Team team;

	private User() {
	};

	public User(String id, String password, String name, String school) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.school = school;
	}
}
