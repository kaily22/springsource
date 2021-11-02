package com.company.annotation.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptUtil {
	
	//text를 PlainText로 바꿈
	public static String encryptSHA256(String plainText) {
	
	//패스워드를 암호화 시키는 메소드 구현
	
			// 패스워드 지정
		//	String plainText = "test1234"; //평문(plainText)
			String sha256="";
		
			try
			{
				// MessageDigest 클래스의 getInstance() 메소드의 매개변수에 "SHA-256 알고리즘"을
				// 지정함으로써 해당 알고리즘에서 해시값을 계산하는 MessageDigest를 구할 수 있다.
				MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
		
				// 데이터(패스워드 평문)를 한다. 즉 '암호화' 한다와 유사한 개념이다.
				mdSHA256.update(plainText.getBytes("UTF-8"));
		
				// 바이트 배열로 해쉬를 반환한다.
				byte[] sha256Hash = mdSHA256.digest();
		
				// StringBuffer 객체는 계속해서 append를 해도 객체는 오직 하나만 생성된다. 메모리 낭비
				StringBuffer hexSHA256hash = new StringBuffer();
		
				// 256 비트로 생성 => 32바이트를 한바이트씩 넘김 1Byte(8bit) -> 16진수 2자리로 변환
				// 16진수 한자리는 4bit
		
				for (byte b : sha256Hash) {
					String hexString = String.format("%02x", b);
					hexSHA256hash.append(hexString);
				}
		
				sha256 = hexSHA256hash.toString();
		
			}catch(NoSuchAlgorithmException e)
			{
				e.printStackTrace();
		
			}catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			return sha256;
		}

}
