package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest3 {

	public static void main(String[] args) {
		//�߰� ���� -2. Filter : ���ǿ� �´� ��� ���͸�
		
		List<String> list = Arrays.asList("abc", "def", "apple", "melon", "text");
		
		list.stream().filter(start -> start.startsWith("a")).forEach(System.out::println);
		
		
		List<String> list2 = Arrays.asList("�ٵ�","�ٳ�","����","����","����");
		list2.stream().filter(start -> start.startsWith("��")).forEach(System.out::println);
		
		
		List<Student> list3 = Arrays.asList(
				new Student("ȫ�浿", 90,96),
				new Student("�����", 83,87),
				new Student("������", 82,97),
				new Student("���켺", 87,92));
		
		
		//�̸��� ������ �����ϴ� �л� ���
		//System.out.println(list3);
		
		list3.stream().filter(start -> start.getName().startsWith("��")).forEach(System.out::println);
	
		//�л� �̸��� ���� => filter->���
		list3.stream().map(stu->stu.getName())
		              .filter(start -> start.startsWith("��"))
		              .forEach(System.out::println);
		
		
		IntStream stream = IntStream.rangeClosed(1, 10);
		//¦���� ���
		//stream.filter(i -> i%2 == 0).forEach(System.out::println);
		
		//2�� ���� �������� 0�� �ƴ� 3���� ���� �������� 0�� �ƴ� ��� ���
		stream.filter(i-> i%2==0 && i%3 != 0).forEach(System.out::println);
	}

}
