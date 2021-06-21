package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest6 {
	public static void main(String[] args) {
	//5. collect() : 요소를 그룹화 하거나 분할한 결과를 컬렉션에 담아서 반환	
	
		List<Student> list3 = Arrays.asList(
				new Student("홍길동", 90,96),
				new Student("김수정", 83,87),
				new Student("김지원", 82,97),
				new Student("정우성", 87,92));
	
		//결과를 화면 출력
		list3.stream().map(stu -> stu.getEng()).forEach(System.out::println);
		
		//결과를 컬렉션에 담아서 받기
		List<Integer> jumsu = list3.stream().map(stu -> stu.getEng()).collect(Collectors.toList());
		
	}

}
