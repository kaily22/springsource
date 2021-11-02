package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.board.BoardDAO;
import com.company.annotation.board.BoardDO;

@Controller
//���� ��Ʈ�ѷ�
/*
 * Ŀ�ǵ�(command) ��ü��?
 * => Ŭ���̾�Ʈ�� �����ִ� �Ķ���Ͱ� �ڵ����� ��ܼ� ��ȯ�Ǵ� ��ü�� ���Ѵ�.
 * �̴� '�ڵ� ��ü ��ȯ'�̶�� �ϸ�, MVC ������ ���Ͽ��� ���� ū �ٽ� ��� �߿�
 * �ϳ��̴�.
 * 
 * ������������ @RequestMapping�� �̿��Ͽ� HandlerMapping ������ ��ü�Ѵ�.
 * 
 */
public class BoardController { //���� ��Ʈ�ѷ�
	
	//��ü �Խñ� ��� �˻�

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO,BoardDAO boardDAO, 
			Model model, String searchField,String searchText) {
		
		model.addAttribute("boardList",boardDAO.getBoardList(searchField, searchText));
		
		return "getBoardList.jsp";
	}
		
	//�Խñ� �󼼺���

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO,Model model) {
		
		//�� ��ü�� select �۾��϶��� �ʿ�-> ����� ��Ƶξ�� �ϱ� ������
		model.addAttribute("board",boardDAO.getBoard(boardDO));
		
		return "getBoard.jsp";
	}

	// [��Ʈ] DML �۾� �ÿ��� BoardDO boardDO, BoardDAO boardDAO �ĸ�Ʈ ��ü�� ������ �ȴ�.
	// �Խñ� ���
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
