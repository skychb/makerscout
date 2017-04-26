package com.makerscouts.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<UploadFile, Integer>{
	public UploadFile findOneByFileName(String fileName);
}
