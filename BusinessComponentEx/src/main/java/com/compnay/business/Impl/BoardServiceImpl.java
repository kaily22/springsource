package com.compnay.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;


//����Ͻ� ���� Ŭ���� 
//��� Ŭ���� ����� �̿� @service ������̼��� ���̸�
//�� Ŭ������ ����Ͻ� ������ ó���ϴ� Ŭ������� ������ �����̳ʿ��� �˷��ش�.

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDO> getBoardList(BoardDO boardDO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(BoardDO boardDO) {
		boardDAO.insertBoard(boardDO);
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		// TODO Auto-generated method stub
		
	}

}
