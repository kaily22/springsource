package lambda;

public class LambdaEx4 {
	
	static void execute(Lambda4 lambda) {
		lambda.run();
	}
	static Lambda4 getRun() {
		Lambda4 lambda = ()->System.out.println("함수형 인터페이스 리턴");
		return lambda;
	}	

	public static void main(String[] args) {
		
		Lambda4 lambda = () -> System.out.println("Lambda4");
		lambda.run();
		
		
		System.out.println();
		execute(getRun());
	}
}
