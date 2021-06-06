package com.spring.persistence;

import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

import static com.spring.persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class BoardDAO {

	public int insertBoard(BoardVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;

		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			result = pstmt.executeUpdate();

			if (result > 0) {
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
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

			con = getConnection();
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
			close(rs);
			close(pstmt);
			close(con);
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
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());

			result = pstmt.executeUpdate();

			if (result > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
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
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();

			if (result > 0) {
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
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
			con = getConnection();
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
			close(con);
			close(pstmt);
			close(rs);

		}
		return vo;
	}
}