package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String title= request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDO boardDO = new BoardDO();
		boardDO.setWriter(writer);
		boardDO.setTitle(title);
		boardDO.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insert(boardDO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", title);
		mav.addObject("writer", writer);
		mav.addObject("content", content);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	
	


}