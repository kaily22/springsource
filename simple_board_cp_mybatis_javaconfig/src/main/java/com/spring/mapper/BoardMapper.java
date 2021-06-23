package com.spring.mapper;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardMapper {

	public int insert(BoardVO vo);
	public int update(BoardVO vo);
	public int delete(int bno);
	public BoardVO read(int bno);
	public List<BoardVO> list();
	
}
