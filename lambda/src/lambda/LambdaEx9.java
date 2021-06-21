package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LambdaEx9 {		
		static List<Student> list = Arrays.asList(
				new Student("ȫ�浿", 90, 96),
				new Student("�����", 85, 87));
		
		public static void printString(Function<Student, String> f) { //�л��� ���
			for(Student stu : list) {
				System.out.println(f.apply(stu));
			}
		}
		public static void printInt(ToIntFunction<Student> f) { //�л� ���� ���
			for(Student stu : list) {
				System.out.println(f.applyAsInt(stu));
			}
		}
		public static void main(String[] args) {
			System.out.println("====[�л� �̸�]====");
			//Function<Student, String> f = obj -> obj.getName();
			printString(obj -> obj.getName());
			
			//ToIntFunction<Student> f = obj->obj.getEng();
			System.out.println("====[���� ����]====");
			printInt(obj -> obj.getEng());
			
			System.out.println("====[���� ����]====");
			printInt(obj -> obj.getMath());
		}
	}

