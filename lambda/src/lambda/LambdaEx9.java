package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LambdaEx9 {		
		static List<Student> list = Arrays.asList(
				new Student("홍길동", 90, 96),
				new Student("김수정", 85, 87));
		
		public static void printString(Function<Student, String> f) { //학생명 출력
			for(Student stu : list) {
				System.out.println(f.apply(stu));
			}
		}
		public static void printInt(ToIntFunction<Student> f) { //학생 점수 출력
			for(Student stu : list) {
				System.out.println(f.applyAsInt(stu));
			}
		}
		public static void main(String[] args) {
			System.out.println("====[학생 이름]====");
			//Function<Student, String> f = obj -> obj.getName();
			printString(obj -> obj.getName());
			
			//ToIntFunction<Student> f = obj->obj.getEng();
			System.out.println("====[영어 점수]====");
			printInt(obj -> obj.getEng());
			
			System.out.println("====[수학 점수]====");
			printInt(obj -> obj.getMath());
		}
	}

