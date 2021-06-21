package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachTest1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","��ſ�","����ȣ");
		
		//����Ʈ ���� ��� ���? => ���� for/ Iterator
		for(String str :list) {
			System.out.println(str);
		}
		System.out.println();
		
		//Stream���� ó�� ����
		Stream<String> stream = list.stream();
		//stream.forEach(item -> System.out.println(item));
		
		System.out.println();
		
		stream.forEach(System.out::println);
		
		
	}

}
