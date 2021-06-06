package com.spring.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	private DataSource ds;
	
	public int insertBoard(BoardVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;

		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<BoardVO> list() {

		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from spring_board";
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setUpdatedate(rs.getDate("updatedate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// update
	public int updateBoard(BoardVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;

		String sql = "update spring_board set title=?,content=?, updatedate=sysdate where bno=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	// delete
	public int deleteBoard(int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;

		String sql = "delete from spring_board where bno=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// select
	public BoardVO select(int bno) {
		BoardVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from spring_board where bno=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setUpdatedate(rs.getDate("updatedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return vo;
	}
}