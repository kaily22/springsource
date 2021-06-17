package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UploadController {
  
	@GetMapping("/uploadForm")
	public void uploadFormGet() {
	  log.info("파일 업로드 폼 요청");
  }
	
	@PostMapping("/uploadForm")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("파일 업로드 요청");
		
		for(MultipartFile f : uploadFile) {
			log.info("upload File Name : " +f.getOriginalFilename());
			log.info("upload File Size : " +f.getSize());
			
			
			//서버 폴더에 전송된 파일 저장하기
			try {
			  f.transferTo(new File("c:\\upload", f.getOriginalFilename()));
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//다운로드
//	@GetMapping(value= "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public ResponseEntity<Resource> downloadFile(String fileName){
//		log.info("download file " +fileName);
//		
//		Resource resource = new FileSystemResource("c:\\upload\\"+fileName);
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			headers.add("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<Resource>(resource, headers,HttpStatus.OK);
//	}
}
