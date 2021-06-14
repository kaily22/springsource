package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class BookRestController {
	
	@Autowired 
	private BookService service;
	
	@GetMapping("rest_list")
	public ResponseEntity<List<BookVO>> getList(){
		log.info("rest 방식으로 list 요청");
		
		return new ResponseEntity<List<BookVO>>(service.list(),HttpStatus.OK);
	}
	
	//http://localhost:8081/1002
	@GetMapping("/{code}")
	public ResponseEntity<BookVO> getRow(@PathVariable("code")int code){
		log.info("rest 방식으로 get 요청");
		
		return new ResponseEntity<BookVO>(service.get(code),HttpStatus.OK);
	}
	//http://localhost:8081/1002 +delete
	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable("code") int code) {
		log.info("rest방식으로 삭제");
	return service.delete(code)>0? new ResponseEntity<String>("success",HttpStatus.OK):
		new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	  
	}

	//http://localhost:8081/update + put(Patch)
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody BookVO vo){
		log.info("rest방식으로 수정 code " +vo.getCode()+"price" +vo.getPrice());
		
		return service.update(vo.getCode(), vo.getPrice())>0?new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	//insert
//	@PostMapping("/rest-insert")
//	public ResponseEntity<String> insert(BookVO vo){
//		log.info("rest방식으로 삽입 code " +vo);
//		
//		return service.insert(vo)>0?new ResponseEntity<String>("success", HttpStatus.OK):
//			new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
//	}
	
	//json형태로
	@PostMapping("/rest-insert")
	public ResponseEntity<String> insert(@RequestBody BookVO vo){
		log.info("rest방식으로 삽입 code " +vo);
		
		return service.insert(vo)>0?new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
}
