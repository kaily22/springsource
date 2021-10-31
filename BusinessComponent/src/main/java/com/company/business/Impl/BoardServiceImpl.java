package com.company.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;
import com.company.business.common.LogAdvice;

/*
 * 구현 클래스이다. 
 * 언 클래스 선언부 위에 서비스를 붙이면 이 클래스는 
 * 비즈니스 로직을 처리하는 클래스라고 스프링 컨테이너에게 알려준다.
 * 
 */

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	//추가
	private LogAdvice log;
	
	//생성자
	public BoardServiceImpl() {
		log = new LogAdvice();
	}
	
	@Override
	public List<BoardDO> getBoardList(BoardDO boardDO) {
		//추가
		log.printLog(); //공통부분
		//보안처리
		return boardDAO.getBoardList(boardDO);
		//트랜잭션
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		log.printLog(); //공통부분
		//보안처리 소스
		return boardDO;
		//트랜잭션 처리ㅣ 소스
	}

	@Override
	public void insertBoard(BoardDO boardDO) {
		log.printLog(); //공통부분
		//보안처리
		boardDAO.insertBoard(boardDO);
		//트랜젝션
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		log.printLog(); //공통부분
		//보안처리
		//트랜젝션
//		return boardDAO.updateBoard(boardDO);
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		log.printLog(); //공통부분
		//보안처리
		//트랜젝션
//		return boardDAO.deleteBoard(boardDO);
	}

}
