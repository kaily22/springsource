package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest3 {

	public static void main(String[] args) {
		//중간 연산 -2. Filter : 조건에 맞는 요소 필터링
		
		List<String> list = Arrays.asList("abc", "def", "apple", "melon", "text");
		
		list.stream().filter(start -> start.startsWith("a")).forEach(System.out::println);
		
		
		List<String> list2 = Arrays.asList("바둑","바나","포도","딸기","바질");
		list2.stream().filter(start -> start.startsWith("바")).forEach(System.out::println);
		
		
		List<Student> list3 = Arrays.asList(
				new Student("홍길동", 90,96),
				new Student("김수정", 83,87),
				new Student("김지원", 82,97),
				new Student("정우성", 87,92));
		
		
		//이름이 김으로 시작하는 학생 출력
		//System.out.println(list3);
		
		list3.stream().filter(start -> start.getName().startsWith("김")).forEach(System.out::println);
	
		//학생 이름만 수집 => filter->출력
		list3.stream().map(stu->stu.getName())
		              .filter(start -> start.startsWith("김"))
		              .forEach(System.out::println);
		
		
		IntStream stream = IntStream.rangeClosed(1, 10);
		//짝수만 출력
		//stream.filter(i -> i%2 == 0).forEach(System.out::println);
		
		//2로 나눈 나머지가 0이 아닌 3으로 나눈 나머지가 0이 아닌 요소 출력
		stream.filter(i-> i%2==0 && i%3 != 0).forEach(System.out::println);
	}

}
