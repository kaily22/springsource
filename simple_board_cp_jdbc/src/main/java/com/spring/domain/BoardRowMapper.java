package com.spring.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BoardVO vo = new BoardVO();
		vo.setBno(rs.getInt("bno"));
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setWriter(rs.getString("writer"));
		vo.setRegdate(rs.getDate("regdate"));
		vo.setUpdatedate(rs.getDate("updatedate"));
		
		return vo;
	}
	

}
