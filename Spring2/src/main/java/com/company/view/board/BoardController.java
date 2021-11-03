package com.company.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.annotation.board.BoardDAO;
import com.company.annotation.board.BoardDO;



@Controller
public class BoardController {  
	
	@Autowired
	BoardDAO boardDAO;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(boardDO));
		return "getBoardList.jsp";
	}
    @RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(boardDO));
		return "getBoard.jsp";
	}
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO) {
		boardDAO.insertBoard(boardDO);
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO) {
		boardDAO.updateBoard(boardDO);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDO boardDO) {
		boardDAO.deleteBoard(boardDO);
		return "getBoardList.do";
	}
}