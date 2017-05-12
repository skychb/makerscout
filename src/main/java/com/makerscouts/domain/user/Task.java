package com.makerscouts.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="task")
public class Task implements Serializable{
	//TODO Serializable이 들어가면 어떤 역할이 들어가는지 알아보자.
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String contents;
	
	@Column
	private Date dueDate;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_task_parent_id"))
	private Team team;
}
