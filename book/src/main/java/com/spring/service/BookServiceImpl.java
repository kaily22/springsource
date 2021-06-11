package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public int insert(BookVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int delete(int code) {
		return mapper.delete(code);
	}

	@Override
	public int update(int code, int price) {
		return mapper.update(code, price);
	}

	@Override
	public List<BookVO> list() {
		return mapper.list();
	}

	@Override
	public List<BookVO> search(String criteria, String keyword) {
		return mapper.search(criteria, keyword);
	}


}
