package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	
	//DAO �۾� - CRUD �۾�
	public boolean insert(BoardVO vo);
	public boolean update(BoardVO vo);
	public boolean delete(int bno);
	public BoardVO getRow(int bno);
	public List<BoardVO> getList();
	

}
