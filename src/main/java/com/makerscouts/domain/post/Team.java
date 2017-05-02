package com.makerscouts.domain.post;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="team")
public class Team implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
}
