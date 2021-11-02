package com.company.annotation.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.annotation.common.JDBCUtil;



public class BoardDAO {
	 //DB ���� ���� ����
	   private Connection con = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   
	   //��ü �Խñ� ��� ��ȸ �޼ҵ�
	   public List<BoardDO> getBoardList(String searchField, String searchText) {
	      System.out.println("===> getBoardList() ��� ó����!!");
	      
	      //array��ü ����
	      List<BoardDO> boardList = new ArrayList<BoardDO>(); 
	      
	      try {
	         con = JDBCUtil.getConnection();
	         
	         /*
	          *  [�߿�] �Խù� �˻� �� => '����' or '�ۼ���'�� �˻� ���� �����ϴ� SQL ������ ��� �ۼ�?
	          *  �ϳ��� SQ ������ �ΰ��� �뵵�� �����!!
	          *  "select * from board" + where+ "order by seq desc";
	          *    �˻� ������ ���� ���� ��� ���ڵ带 �˻��ϰ�,
	          *    �˻� ������ �ִ� ���� �Ű������� �Ѿ�� ��쿡�� ���ǿ� �����ϴ� ���ڵ常 �˻��ϰڴ�.
	          *  
	          */
	         String where = "";

	         // �˻� ������ null�� �ƴ� �� where�� ����� �ι�° ���� ����

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
	   
	   //�Խñ� ��ȣ ���ǿ� �´� �ش� �Խñ۸� �˻��ϴ� �޼ҵ�
	   public BoardDO getBoard(BoardDO boardDO) {
	      System.out.println("===> getBoard() ó����!");
	      
	      
	      BoardDO board = null;
	      
	      try {
	         
	         con = JDBCUtil.getConnection();
	         
	         //[�߿�] �ش� �Խñ��� ��ȸ��(cnt)�� 1���� ��Ų��.
	         String UPDATE_CNT = "update board set cnt=cnt+1 where seq=?";
	         pstmt = con.prepareStatement(UPDATE_CNT);
	         pstmt.setInt(1, boardDO.getSeq());
	          pstmt.executeUpdate();
	         
	         //�׷� ���� �ش� �Խñ� ��������
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
	   
	   //�Խù� �����ϱ�
	   public void updateBoard(BoardDO boardDO) {
	      
	      System.out.println("====> updateBoard() ó����!!");
	      
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
	      
	      System.out.println("========> deleteBoard() ó����!");
	      
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
	      
	      System.out.println("======>insertBoard() ��� ó����!");
	      
	      try {
	         con = JDBCUtil.getConnection();
	         //seq�� null�̸� 0���� ��ȯ����(�κ������� insert�Ұ�� ���̺� ������ �÷��� ����)
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
