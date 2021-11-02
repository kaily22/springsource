package com.company.annotation.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	//H2 DB 연도오 관련 소스
	
		static final String driver = "org.h2.Driver";
		static final String url="jdbc:h2:tcp://localhost/~/test";
		
		public static Connection getConnection() throws Exception {
			
			try {
				
				//드라이버 로딩
				Class.forName(driver);
				
				
				//Connection 객체 만들기
				Connection con = DriverManager.getConnection(url,"sa","");
				return con;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		
		/*
		 * 메소드 오버로딩 => 다형성 구현
		 */
		//자원 해제시키는 메소드(DML 작업 종료시 호출되는 메소드)
		
		public static void close(PreparedStatement pstmt, Connection con) {
				if(pstmt != null) {
					try {
						if(!pstmt.isClosed()) pstmt.close();{
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						pstmt = null;
					}
				}
				
				if(con!= null) {
					try {
						if(!con.isClosed()) con.close(); {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						con = null;
					}
				}
		}
		
		//select 작업 종료 되었을 때 호출되는 메소드
			public static void close(ResultSet rs,PreparedStatement pstmt,Connection con) {
				if(rs != null) {
					try {
						if(!rs.isClosed()) rs.close(); {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						rs = null;
					}
				}
				
				if(pstmt != null) {
					try {
						if(!pstmt.isClosed()) pstmt.close(); {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						pstmt = null;
					}
				}
				
				if(con != null) {
					try {
						if(!con.isClosed()) con.close(); {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						con = null;
					}
				}
			}	


}
