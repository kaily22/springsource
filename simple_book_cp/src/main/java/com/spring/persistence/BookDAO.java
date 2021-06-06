package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

import javax.sql.DataSource;

@Repository

public class BookDAO {
	
	@Autowired
	private DataSource ds;

	public int isinsert(BookVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into bookTBL(code,title,writer,price) values(?,?,?,?)";

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
				pstmt.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int update(BookVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;

		String sql = "update bookTBL set price=? where code = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setInt(2, vo.getCode());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int delete(int code) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from bookTBL where code=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				pstmt.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public BookVO getRow(int code) {

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		BookVO vo = null;

		String sql = "select * from bookTBL where code = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return vo;
	}

	public List<BookVO> getList() {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();

		String sql = "select * from bookTBL";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}
