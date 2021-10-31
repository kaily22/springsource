package com.company.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;
import com.company.business.common.LogAdvice;

/*
 * ���� Ŭ�����̴�. 
 * �� Ŭ���� ����� ���� ���񽺸� ���̸� �� Ŭ������ 
 * ����Ͻ� ������ ó���ϴ� Ŭ������� ������ �����̳ʿ��� �˷��ش�.
 * 
 */

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	//�߰�
	private LogAdvice log;
	
	//������
	public BoardServiceImpl() {
		log = new LogAdvice();
	}
	
	@Override
	public List<BoardDO> getBoardList(BoardDO boardDO) {
		//�߰�
		log.printLog(); //����κ�
		//����ó��
		return boardDAO.getBoardList(boardDO);
		//Ʈ�����
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		log.printLog(); //����κ�
		//����ó�� �ҽ�
		return boardDO;
		//Ʈ����� ó���� �ҽ�
	}

	@Override
	public void insertBoard(BoardDO boardDO) {
		log.printLog(); //����κ�
		//����ó��
		boardDAO.insertBoard(boardDO);
		//Ʈ������
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		log.printLog(); //����κ�
		//����ó��
		//Ʈ������
//		return boardDAO.updateBoard(boardDO);
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		log.printLog(); //����κ�
		//����ó��
		//Ʈ������
//		return boardDAO.deleteBoard(boardDO);
	}

}
