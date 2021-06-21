package lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {

		// 중간 연산 -1.map : 스트림 요소에 저장된 값 중에서 원하는 필드만 추출 or 특정 형태로 변환

		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("file3.txt"),
				new File("file4.txt"));

		// 파일명만 추출
		// new File("file1.txt").getName(); File f = new File("file2.txt"); f.getName();

		// 파일명 수집 (file이 갖고 있는 getName 수집-> 화면에 출력)
		stream.map(File::getName).forEach(f -> System.out.print(f));

		List<String> list = Arrays.asList("abc", "def", "apple", "melon", "text");

		// 대문자로 변경 -> 출력
		List<String> upperList = new ArrayList<String>();
		for (String str : list) {
			upperList.add(str.toUpperCase());
		}
		System.out.println(upperList);
		
		Stream<String> stream2 =list.stream();
		Stream<String> alpha = stream2.map(String::toUpperCase);
		alpha.forEach(c -> System.out.println(c));
	}
	
}
