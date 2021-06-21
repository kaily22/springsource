package lambda;

import java.lang.String;
import java.util.function.Function;

public class LambdaEx8 {

	public static void main(String[] args) {
		//Math.max(35, 45); //Math :: max ->¶÷´Ù½Ä
		
		Function<String, Integer> f = Integer::parseInt;
		System.out.println(f.apply("568")+8);
		
	}
}
