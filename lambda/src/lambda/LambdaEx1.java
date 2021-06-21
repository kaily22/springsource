package lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		
		//�͸� ���� ��ü
		Lambda1 lambda = new Lambda1() {
			
			@Override
			public void method() {
				System.out.println("�Լ��� �������̽�");
			}
		};
		lambda.method();
		
//		���ٽ�
		Lambda1 lambda1 = () -> System.out.println("�Լ��� �������̽�");
		lambda1.method();
		
		//���� ���-�͸�����ü
		Lambda1 lambda2 = new Lambda1() {
			@Override
			public void method() {
			int i=10;
			System.out.println(i*i);
		 }
		};
		lambda2.method();
		
		//���ٽ�
		lambda2 = () -> {
			int i=10;
			System.out.println(i*i);
		};
		lambda2.method();

	}

}
