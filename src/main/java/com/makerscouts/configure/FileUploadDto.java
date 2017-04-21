package com.makerscouts.configure;

import org.springframework.web.multipart.MultipartFile;
@SuppressWarnings("serial")
public class FileUploadDto{
	
	private String CKEditorFuncNum;
	private MultipartFile upload;
	private String newFileName;
	private String ImageUrl;
	
	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}
	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}
	
}
