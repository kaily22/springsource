package lambda;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;


public class StreamTest7 {
	public static void main(String[] args) {
		
		IntStream stream = Arrays.stream(new int[] {1,2,3,4,5,6});
		
		//2�� ��� ����
//		long count = stream.filter(i -> i%2 ==0).count();
//		System.out.println("2�� ��� ����: " +count);
		
		//2�� ��� ��
//		int sum = stream.filter(i -> i%2 ==0).sum();
//		System.out.println("2�� ��� �� : " +sum);
		
		//2�� ��� ���
//		OptionalDouble average = stream.filter(i -> i%2 == 0).average();
//		System.out.println("2�� ����� �� : " +average);
		
		
		//2�� ��� �ִ�
//		OptionalInt max = stream.filter(i -> i%2 == 0).max();
//		System.out.println("2�� ����� �ִ밪 : " +max);
		
		//2�� ��� �ּ�
		OptionalInt min = stream.filter(i -> i%2 == 0).min();
		System.out.println("2�� ����� �ּ� : " +min);
		
	}

}
