package com.company.annotation.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.annotation.common.JDBCUtil;
import com.company.annotation.common.PasswordEncryptUtil;



public class UserDAO {

	//DB ���� ���� ����
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//�߰�
	//ȸ�� ���� �� �н����带 ��ȣȭ ��Ų �����͸� ������ �������� ����
	String pwEncrypt;
	
	//sql ��ɾ�
	private final String USER_GET = "select * from users where id=? and password=?";
	
	//�߰�
	private final String USER_INSERT = "insert into users values(?,?,?,?,?)";
	
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
				//�߰�
				user.setName(rs.getString("Name"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return user;
	}//end getUser() =====================================
	
	//ȸ������ insert�޼ҵ� ����
	public void insertUser(UserDO userDO) {
		System.out.println("===> insertUser() ��� ó��");
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, userDO.getId());
			pstmt.setString(2, userDO.getPassword());
			
			//�Ѿ�� �н����带 ��ȣȭ ���Ѽ� ����° ����ǥ ������ �����Ѵ�.
			String plainText = userDO.getPassword();
			pwEncrypt = PasswordEncryptUtil.encryptSHA256(plainText);
			pstmt.setString(3, pwEncrypt);
			pstmt.setString(4, userDO.getName());
			pstmt.setString(5, userDO.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertUser() : " +e);
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
