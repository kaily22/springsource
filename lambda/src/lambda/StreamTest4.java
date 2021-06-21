package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest4 {

	public static void main(String[] args) {
		//�߰� ���� -3. distinct : �ߺ�����
		
		List<String> list2 = Arrays.asList("�ٵ�","�ٳ�","����","����","����", "����","����");
		
		list2.stream().distinct().forEach(System.out::println);
		
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.back"), new File("file3.txt"), new File("file4.java"), 
				new File("Ex1"));
		
//		File f = new File("file5.txt");
		
//		if(f.getName().indexOf(".")>-1) {
//		 int pos = f.getName().indexOf(".")+1;
//		 System.out.println(f.getName().substring(pos));
//		 }		
		
		
	stream.map(File::getName) //���ϸ� ���� => {file1.txt,file2.back,file3.txt,"file4.java","EX1"}
	      .filter(f -> f.indexOf(".") > -1) //Ȯ���ڰ� �ִ� �͸� {file1.txt,file2.back,file3.txt,"file4.java"}
	      .map(f -> f.substring(f.indexOf(".")+1)) //Ȯ���ڸ� ����
	      .distinct() //�ߺ� ����
	      .forEach(System.out::println); //���
	}

}
