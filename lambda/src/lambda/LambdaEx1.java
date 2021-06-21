package lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		
		//익명 구현 객체
		Lambda1 lambda = new Lambda1() {
			
			@Override
			public void method() {
				System.out.println("함수적 인터페이스");
			}
		};
		lambda.method();
		
//		람다식
		Lambda1 lambda1 = () -> System.out.println("함수적 인터페이스");
		lambda1.method();
		
		//기존 방식-익명구현객체
		Lambda1 lambda2 = new Lambda1() {
			@Override
			public void method() {
			int i=10;
			System.out.println(i*i);
		 }
		};
		lambda2.method();
		
		//람다식
		lambda2 = () -> {
			int i=10;
			System.out.println(i*i);
		};
		lambda2.method();

	}

}
