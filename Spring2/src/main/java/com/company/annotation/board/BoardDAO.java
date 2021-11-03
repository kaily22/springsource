package com.company.annotation.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.annotation.board.BoardDO;
import com.company.annotation.common.JDBCUtil;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession mybatis;
		
	public List<BoardDO> getBoardList(BoardDO boardDO){		
		return mybatis.selectList("BoardDAO.getBoardList", boardDO);		
	} 
	
	public BoardDO getBoard(BoardDO boardDO) {		
		return mybatis.selectOne("BoardDAO.getBoard", boardDO);		
	}
	
	public void updateBoard(BoardDO boardDO) {		
		mybatis.update("BoardDAO.updateBoard", boardDO);		
	} 
	
	public void deleteBoard(BoardDO boardDO) {		
		mybatis.delete("BoardDAO.deleteBoard", boardDO);		
	}
	
	public void insertBoard(BoardDO boardDO) {		
		mybatis.insert("BoardDAO.insertBoard", boardDO);		
	}
}
