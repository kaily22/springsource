package com.company.annotation.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.annotation.common.JDBCUtil;



public class BoardDAO {
	 //DB 관련 변수 선언
	   private Connection con = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   
	   //전체 게시글 목록 조회 메소드
	   public List<BoardDO> getBoardList(String searchField, String searchText) {
	      System.out.println("===> getBoardList() 기능 처리됨!!");
	      
	      //array객체 생성
	      List<BoardDO> boardList = new ArrayList<BoardDO>(); 
	      
	      try {
	         con = JDBCUtil.getConnection();
	         
	         /*
	          *  [중요] 게시물 검색 시 => '제목' or '작성자'로 검색 조건 제시하는 SQL 문장을 어떻게 작성?
	          *  하나의 SQ 문장을 두가지 용도로 사용함!!
	          *  "select * from board" + where+ "order by seq desc";
	          *    검색 조건이 없는 경우는 모든 레코드를 검색하고,
	          *    검색 조건이 있는 경우는 매개변수로 넘어온 경우에는 조건에 만족하는 레코드만 검색하겠다.
	          *  
	          */
	         String where = "";

	         // 검색 조건이 null이 아닐 땐 where을 만들고 두번째 문장 실행

	         if(searchField != null && searchText != null ) {
	            where = "where " +searchField + " like '%"+searchText+ "%'";
	         }

	         String Condition_SQL = "select * from board " + where + " order by seq desc";
	         
	         pstmt = con.prepareStatement(Condition_SQL);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            BoardDO board = new BoardDO();
	            board.setSeq(rs.getInt("SEQ"));
	            board.setTitle(rs.getString("TITLE"));
	            board.setWriter(rs.getString("WRITER"));
	            board.setContent(rs.getString("CONTENT"));
	            board.setRegdate(rs.getDate("REGDATE"));
	            board.setCnt(rs.getInt("CNT"));
	            
	            boardList.add(board);
	            
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         JDBCUtil.close(rs,pstmt,con);
	      }
	      
	      return boardList;
	      
	   }
	   
	   //게시글 번호 조건에 맞는 해당 게시글만 검색하는 메소드
	   public BoardDO getBoard(BoardDO boardDO) {
	      System.out.println("===> getBoard() 처리됨!");
	      
	      
	      BoardDO board = null;
	      
	      try {
	         
	         con = JDBCUtil.getConnection();
	         
	         //[중요] 해당 게시글의 조회수(cnt)를 1증가 시킨다.
	         String UPDATE_CNT = "update board set cnt=cnt+1 where seq=?";
	         pstmt = con.prepareStatement(UPDATE_CNT);
	         pstmt.setInt(1, boardDO.getSeq());
	          pstmt.executeUpdate();
	         
	         //그런 다음 해당 게시글 가져오기
	         String BOARD_GET = "select * from board where seq = ?";
	         pstmt = con.prepareStatement(BOARD_GET);
	         pstmt.setInt(1, boardDO.getSeq());
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            board = new BoardDO();
	            
	            board.setSeq(rs.getInt("SEQ"));
	            board.setTitle(rs.getString("TITLE"));
	            board.setContent(rs.getString("CONTENT"));
	            board.setWriter(rs.getString("WRITER"));
	            board.setRegdate(rs.getDate("REGDATE"));
	            board.setCnt(rs.getInt("CNT"));
	            
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         JDBCUtil.close(rs,pstmt,con);
	      }
	      return board;
	   }//end getBoard() ======================================================
	   
	   //게시물 수정하기
	   public void updateBoard(BoardDO boardDO) {
	      
	      System.out.println("====> updateBoard() 처리됨!!");
	      
	      try {
	         
	         con = JDBCUtil.getConnection();
	         String Board_Update = "update board set title=?, content=? where seq=?";
	         
	         pstmt = con.prepareStatement(Board_Update);
	         pstmt.setString(1, boardDO.getTitle());
	         pstmt.setString(2, boardDO.getContent());
	         pstmt.setInt(3, boardDO.getSeq());
	         
	         pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         JDBCUtil.close(rs, pstmt, con);
	      }
	      
	   } //end update()======================================================================
	   
	   
	   public void delete(BoardDO boardDO) {
	      
	      System.out.println("========> deleteBoard() 처리됨!");
	      
	      try {
	         
	         con = JDBCUtil.getConnection();
	         
	         String Delete_Board = "delete from board where seq = ?";
	         pstmt = con.prepareStatement(Delete_Board);
	         pstmt.setInt(1, boardDO.getSeq());
	         
	         pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         JDBCUtil.close(rs,pstmt,con);
	      }
	   }
	   
	   //end delete ==========================================================
	   
	   public void insert(BoardDO boardDO) {
	      
	      System.out.println("======>insertBoard() 기능 처리됨!");
	      
	      try {
	         con = JDBCUtil.getConnection();
	         //seq가 null이면 0으로 변환해줌(부분적으로 insert할경우 테이블 다음에 컬럼명 제시)
	         String Insert_Board = "insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	         pstmt = con.prepareStatement(Insert_Board);

	         pstmt.setString(1, boardDO.getTitle());
	         pstmt.setString(2, boardDO.getWriter());
	         pstmt.setString(3, boardDO.getContent());
	         
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         JDBCUtil.close(rs,pstmt, con);
	         
	      }
	      
	   }
}
