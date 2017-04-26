package com.makerscouts.domain.post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="uploadfile")
public class UploadFile {
	@Id
	@GeneratedValue
	int id;
	
	@Column
	String fileName;
	
	@Column
	String saveFileName;
	
	@Column
	String filePath;
	
	@Column
	String contentType;
	
	@Column
	long size;
	
	Date subDate;
}
