package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachTest2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("ȫ�浿", 90, 96),
				new Student("�����", 85, 87));
		
		
		//ȫ�浿 - 90, 96
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			System.out.println(s.getName() + " - " +s.getEng()+"," + s.getMath());
		});
		
				
	}

}
