package com.company.annotation.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	//H2 DB ������ ���� �ҽ�
	
		static final String driver = "org.h2.Driver";
		static final String url="jdbc:h2:tcp://localhost/~/test";
		
		public static Connection getConnection() throws Exception {
			
			try {
				
				//����̹� �ε�
				Class.forName(driver);
				
				
				//Connection ��ü �����
				Connection con = DriverManager.getConnection(url,"sa","");
				return con;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		
		/*
		 * �޼ҵ� �����ε� => ������ ����
		 */
		//�ڿ� ������Ű�� �޼ҵ�(DML �۾� ����� ȣ��Ǵ� �޼ҵ�)
		
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
		
		//select �۾� ���� �Ǿ��� �� ȣ��Ǵ� �޼ҵ�
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
