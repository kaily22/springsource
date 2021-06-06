package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	
	//DAO 작업 - CRUD 작업
	public boolean insert(BoardVO vo);
	public boolean update(BoardVO vo);
	public boolean delete(int bno);
	public BoardVO getRow(int bno);
	public List<BoardVO> getList();
	

}
