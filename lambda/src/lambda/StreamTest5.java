package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest5 {

	public static void main(String[] args) {
		//4.skip : �ǳ� �ٱ�, limit : ��� ��� ����
	
	
		List<String> list2  = Arrays.asList("�ٵ�","�ٳ���","����","����","����","����","����");
		
		
		list2.stream()
		     .skip(2)
		     .limit(3)
		     .forEach(System.out::println);
	
	}
	
}
