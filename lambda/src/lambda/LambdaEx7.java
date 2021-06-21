package lambda;

import java.util.function.IntBinaryOperator;

public class LambdaEx7 {

	private static int[] scores = { 92, 95, 87 };

	public static int maxOrmin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// operator : 리턴, 매개값 o -> 주로 매개값을 연산하고 결과를 리턴
		int max = maxOrmin(
				(a, b) -> {
					if (a >= b)
						return a;
					else
						return b;
				});

		System.out.println("최대값 : " + max);
		int min = maxOrmin((a, b) -> {
			if (a <= b)
				return a;
			else
				return b;
		});
		System.out.println("최소값 : " + min);
	}

}
