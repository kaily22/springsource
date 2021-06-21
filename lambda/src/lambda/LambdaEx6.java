package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx6 {

	public static void main(String[] args) {
		//�ڹ� ǥ�� API�� �Լ��� �������̽�
		//Consumer : �Ű� ���� �ְ� ���� ���� x
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("Hello");
		
		//Supplier  : �Ű� ���� ���� ���� ���� ����
		//BooleanSupplier / InputSupplier
		Supplier<Integer> supplier = () -> (int)(Math.random()*100)+1;
		//IntSupplier<Integer> supplier = () -> (int)(Math.random()*100)+1;
		System.out.println(supplier.get());
		
		//Function : �Ű� ���� ���ϰ� ��� ����, �ַ� �Ű����� ���ϰ����� ����
		// DoubleFunction / IntLongFunction....
		Function<Integer, Integer> function = i -> i/10 * 10 ;
		System.out.println(function.apply(561));
		
		//Operator : �Ű���, ���ϰ� o, �ַ� �Ű����� �����ϰ� ����� ����
		
		//Predicate : �Ű��� o ,���� Ÿ���� boolean, �Ű����� �����ؼ� t/f�� ����
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(6));
	}

}
