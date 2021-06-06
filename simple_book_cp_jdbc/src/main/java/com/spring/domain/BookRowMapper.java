package com.spring.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<BookVO> {

	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BookVO vo = new BookVO();
		vo.setCode(rs.getInt(1));
		vo.setTitle(rs.getString(2));
		vo.setWriter(rs.getString(3));
		vo.setPrice(rs.getInt(4));
		
		return vo;
	}

}
