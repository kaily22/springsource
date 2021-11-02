package �н����带��ȣȭ��Ű��;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 
 * �ڹٿ��� SHA �˰����� ����Ϸ��� MessageDigest Ŭ������ �̿��Ѵ�.
 * update() �޼ҵ带 ȣ���Ҷ����� ��ü ���� ����� digest ���� ����ؼ� ���ŵȴ�.
 * ���������� digest() �޼ҵ带 ȣ���ϸ� �� ���� ������ �� �ִ�.
 * 
 */



public class PasswordEncryptUtil {

	public static void main(String[] args) {
		
		//�н����� ����
		String plainText = "test1234"; //��(plainText)
		String sha256="";
		
		try {
			//MessageDigest Ŭ������ getInstance() �޼ҵ��� �Ű������� "SHA-256 �˰���"��
			//���������ν� �ش� �˰��򿡼� �ؽð��� ����ϴ� MessageDigest�� ���� �� �ִ�.
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			
			//������(�н����� ��)�� �Ѵ�. �� '��ȣȭ' �Ѵٿ� ������ �����̴�.
			mdSHA256.update(plainText.getBytes("UTF-8"));
			
			//����Ʈ �迭�� �ؽ��� ��ȯ�Ѵ�.
			byte[] sha256Hash = mdSHA256.digest();
			
			//StringBuffer ��ü�� ����ؼ� append�� �ص� ��ü�� ���� �ϳ��� �����ȴ�. �޸� ����
			StringBuffer hexSHA256hash = new StringBuffer();
			
			//256 ��Ʈ�� ���� => 32����Ʈ�� �ѹ���Ʈ�� �ѱ� 1Byte(8bit) -> 16���� 2�ڸ��� ��ȯ 
			// 16���� ���ڸ��� 4bit 
			
			for(byte b : sha256Hash) {
				String hexString = String.format("%02x", b);
				hexSHA256hash.append(hexString);
			}
			
			sha256 = hexSHA256hash.toString();
					
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(sha256);
		//937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244
		
	}

}
