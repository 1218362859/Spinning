package com.femtoapp.service.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


public class cc {

	@Test
	public void ccc() throws IOException {
		File doc = new File("C:\\Users\\femtoapp\\Desktop\\1.png"); 
		
		FileInputStream input = new FileInputStream(doc); 
		
		MultipartFile multipartFile = new MockMultipartFile("file", doc.getName(), "text/plain", IOUtils.toByteArray(input));
System.out.println(multipartFile);
		
	}
}
