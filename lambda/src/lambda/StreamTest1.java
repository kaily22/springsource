package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("���", "�ٳ���","����","����","�޷�");
		String[] strArr = {"�����","�ڵ���","��","������","����","�������"};
		
		//���� Collections : �÷��� ��ü�� �ٷ�� ���� �����ϴ� Ŭ����
		Collections.sort(strList);
		for(String s : strList) {
			System.out.println(s+" ");
		}
		
		System.out.println();
		
		//�迭 ����
		Arrays.sort(strArr);
		for(String s : strArr) {
			System.out.println(s+" ");
		}
		System.out.println();
		
		//�迭�� ���������� x
//		Stream<String> stream1 = strList.stream();
//		Stream<String> stream2 = Arrays.stream(strArr);
//		
//		stream1.sorted().forEach(System.out::println);
//		System.out.println();
//		stream2.sorted().forEach(System.out::print);
		
		strList.stream()
		       .sorted()
		       .forEach(System.out::print);
		
		Arrays.stream(strArr)
		      .sorted()
		      .forEach(System.out::print);
		
	}

}
