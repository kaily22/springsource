package com.company.business.board;

import java.util.List;

public interface BoardService {
	//�߻� �޼ҵ�
		//��ü �Խñ� ��� ��ȸ
		List<BoardDO> getBoardList(BoardDO boardDO);
		
		//�Խñ� �󼼺���
		BoardDO getBoard(BoardDO boardDO);
		
		//�Խñ� ���
		void insertBoard(BoardDO boardDO);
		
		//�Խñ� ����
		void updateBoard(BoardDO boardDO);
		
		//�Խñ� ����
		void deleteBoard(BoardDO boardDO);
}
