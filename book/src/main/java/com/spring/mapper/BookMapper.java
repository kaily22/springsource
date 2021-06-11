package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookVO;

public interface BookMapper {
	
	
	public int insert(BookVO vo);
	public int delete(int code);
	public int update(@Param("code") int code, @Param("price") int price);
	public List<BookVO> list();
	public List<BookVO> search(@Param("criteria") String criteria, @Param("keyword") String keyword);
}

