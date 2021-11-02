package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.board.BoardDAO;
import com.company.annotation.board.BoardDO;

@Controller
//통합 컨트롤러
/*
 * 커맨드(command) 객체란?
 * => 클라이언트가 보내주는 파라미터가 자동으로 담겨서 반환되는 객체를 말한다.
 * 이는 '자동 객체 변환'이라고 하며, MVC 디자인 패턴에서 가장 큰 핵심 기술 중에
 * 하나이다.
 * 
 * 스프링에서는 @RequestMapping을 이용하여 HandlerMapping 설정을 대체한다.
 * 
 */
public class BoardController { //통합 컨트롤러
	
	//전체 게시글 목록 검색

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO,BoardDAO boardDAO, 
			Model model, String searchField,String searchText) {
		
		model.addAttribute("boardList",boardDAO.getBoardList(searchField, searchText));
		
		return "getBoardList.jsp";
	}
		
	//게시글 상세보기

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO,Model model) {
		
		//모델 객체는 select 작업일때만 필요-> 결과를 담아두어야 하기 때문에
		model.addAttribute("board",boardDAO.getBoard(boardDO));
		
		return "getBoard.jsp";
	}

	// [힌트] DML 작업 시에는 BoardDO boardDO, BoardDAO boardDAO 컴맨트 객체로 받으면 된다.
	// 게시글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insert(boardDO);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		return "getBoardList.do";
		
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.delete(boardDO);
		return "getBoardList.do";
		
	}
	
}
