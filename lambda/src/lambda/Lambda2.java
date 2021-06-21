package lambda;


@FunctionalInterface
public interface Lambda2 {
	public void method(int x);
	//public void method2(); 람다식의 타켓타입의 인터페이스는 추상메소드가 하나만 존재해야 함
	// @FunctionalInterface 컴파일러가 오류를 체크
	
	
	
}
