package com.company.Model2.Board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class UserDAO {

	//DB ���� ���� ����
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//sql ���ɾ�
	private final String USER_GET = "select id, password from users where id=? and password=?";
	
	//�α��� user��ȸ(select)
	public UserDO getUser(UserDO userobj) {
		UserDO user = null;
		
		try {
			System.out.println("====>JDBC�� getUser() ��� ó��");
			
			//JDBCUtil=> ���� ��ü �޾ƿ���
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, userobj.getId());
			pstmt.setString(2, userobj.getPassword());
			
			//select���� executeQuery()
			rs = pstmt.executeQuery();
			
			//rs�� ����Ű�� �� ��������
			if(rs.next()) {
				//userDO ��ü ����
				user = new UserDO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return user;
	}
	
}