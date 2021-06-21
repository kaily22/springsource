package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachTest1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김신용","김지호");
		
		//리스트 안의 요소 출력? => 향상된 for/ Iterator
		for(String str :list) {
			System.out.println(str);
		}
		System.out.println();
		
		//Stream으로 처리 가능
		Stream<String> stream = list.stream();
		//stream.forEach(item -> System.out.println(item));
		
		System.out.println();
		
		stream.forEach(System.out::println);
		
		
	}

}
