package com.makerscouts.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="team")
public class Team implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String school;
	
	@Column
	private String teamName;
	
	@Column
	private Date created;
	
	@JsonIgnore
	@OneToMany(mappedBy="team", fetch=FetchType.LAZY)
	private List<User> user;
	
	@JsonIgnore
	@OneToMany(mappedBy="team", fetch=FetchType.LAZY)
	private List<Task> task;
	
	public Team(){};
}
