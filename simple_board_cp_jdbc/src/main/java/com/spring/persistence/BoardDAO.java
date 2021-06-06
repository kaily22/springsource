package com.spring.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardRowMapper;
import com.spring.domain.BoardVO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//@Component
@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertBoard(BoardVO vo) {

		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql,vo.getTitle(),vo.getContent(),vo.getWriter());
		
		return result;
	}

	public List<BoardVO> list() {

		String sql = "select * from spring_board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}

	// update
	public int updateBoard(BoardVO vo) {

		String sql = "update spring_board set title=?,content=?, updatedate=sysdate where bno=?";
		int result = jdbcTemplate.update(sql,vo.getTitle(),vo.getContent(),vo.getBno());
		
		return result;

	}

	// delete
	public int deleteBoard(int bno) {
		String sql = "delete from spring_board where bno=?";
		int result = jdbcTemplate.update(sql,bno);
		return result;
	}

	// select
	public BoardVO select(int bno) {
		String sql = "select * from spring_board where bno=?";
		return jdbcTemplate.queryForObject(sql,new BoardRowMapper(),bno);
	}
}