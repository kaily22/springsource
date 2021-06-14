package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleVO;

@RestController
public class RestControllerTest {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping(value="/send",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("Hong");
		sample.setLastName("Dong");
	
		return sample;
	}
	
	@GetMapping(value="/send-list",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleVO> sendList() {
		
	List<SampleVO> list = new ArrayList<SampleVO>();
	
	for(int i=0; i<10; i++) {	
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("Hong");
		sample.setLastName("Dong");
		list.add(sample);
	}
		return list;
	}
	
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(double height,double weight){
		SampleVO vo = new SampleVO();
		vo.setFirstName(height +"");
		vo.setLastName(weight +"");
		
		ResponseEntity<SampleVO> entity = null;
		
		if( height < 150) {
			entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
		}else {
			entity =  ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return entity;	
	}

	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category : "+cat, "prdocutId : "+pid};
	}
	
}











