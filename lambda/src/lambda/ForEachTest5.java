package lambda;

import java.util.stream.IntStream;

public class ForEachTest5 {

	
	static int sum = 0;
	
	public static void main(String[] args) {
		IntStream stream = IntStream.range(1, 100);
		
		stream.forEach(i -> sum+=i);
		System.out.println("1~99±îÁö ÇÕ " +sum);
		
	}

}
