package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest6 {
	public static void main(String[] args) {
	//5. collect() : ��Ҹ� �׷�ȭ �ϰų� ������ ����� �÷��ǿ� ��Ƽ� ��ȯ	
	
		List<Student> list3 = Arrays.asList(
				new Student("ȫ�浿", 90,96),
				new Student("�����", 83,87),
				new Student("������", 82,97),
				new Student("���켺", 87,92));
	
		//����� ȭ�� ���
		list3.stream().map(stu -> stu.getEng()).forEach(System.out::println);
		
		//����� �÷��ǿ� ��Ƽ� �ޱ�
		List<Integer> jumsu = list3.stream().map(stu -> stu.getEng()).collect(Collectors.toList());
		
	}

}
