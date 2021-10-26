package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

//@Component("service") => db작업은 서비스 어노테이션을 쓴다.
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;

	@Override
	public boolean insert(BoardVO vo) {
		return dao.insertBoard(vo) >0 ? true:false ;
	}

	@Override
	public boolean update(BoardVO vo) {
		return dao.updateBoard(vo) >0 ? true:false;
	}

	@Override
	public boolean delete(int bno) {
		return dao.deleteBoard(bno) > 0 ? true:false;
	}

	@Override
	public BoardVO getRow(int bno) {
		return dao.select(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return dao.list();
	}

}
