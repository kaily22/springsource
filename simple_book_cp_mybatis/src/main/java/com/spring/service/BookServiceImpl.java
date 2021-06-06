package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service("service") //BookServiceImpl로 잡힘 (service 이름 설정 안하면)

public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;

	@Override
	public boolean insert(BookVO vo) {
		return mapper.insert(vo) > 0 ? true : false;
	}

	@Override
	public boolean update(BookVO vo) {
		return mapper.update(vo) > 0 ? true : false;
	}

	@Override
	public boolean delete(int code) {
		return mapper.delete(code) > 0 ? true : false;
	}

	@Override
	public BookVO getRow(int code) {
		// TODO Auto-generated method stub
		return mapper.read(code);
	}

	@Override
	public List<BookVO> getList() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

}
