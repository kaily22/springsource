package lambda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ForEachTest4 {

	public static void main(String[] args) {
		
		String strArr[] = {"사과", "바나나","딸기","포도","메론"};
		
		//배열을 쉽게 다를 수 있도록 제공 => Arrays
		Stream<String> stream = Arrays.stream(strArr);
		stream.forEach(s -> System.out.println(s));
		
		
		//디렉터리에서 스트림 넘어오기
		Path path = Paths.get("c:\\upload\\2021\\06\\18");
//		
//		Stream<Path> stream1 = null;
//		try {
//			stream1 = Files.list(path);
//			stream1.forEach(f -> System.out.println(f.getFileName()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			stream1.close();
//		}
//		
		
		//path 객체 생성 -> try안에 써서 들어오면 알아서 close
		try(Stream<Path> stream1 = Files.list(path)) {
			stream1.forEach(f -> System.out.println(f.getFileName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
