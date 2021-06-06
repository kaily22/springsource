package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import static com.spring.persistence.JDBCUtil.*;

import com.spring.domain.BookVO;

@Repository
public class BookDAO {
	public int isinsert(BookVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into bookTBL(code,title,writer,price) values(?,?,?,?)";
		
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
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

	
	
	public int update(BookVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		
		String sql = "update bookTBL set price=? where code = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setInt(2, vo.getCode());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
			close(pstmt);
		}
		return result;
	}
	public int delete(int code) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from bookTBL where code=?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
			
			if(result>0) {
				commit(con);
			}else {
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

	public BookVO getRow(int code) {
		
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		BookVO vo = null;
		
		String sql ="select * from bookTBL where code = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
			close(con);
			
		}
		return vo;
	}
	
	public List<BookVO> getList(){
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "select * from bookTBL";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				list.add(vo);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
	}
}
