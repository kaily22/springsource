package lambda;

public class Student {
	private String name;
	private int eng;
	private int math;
	public Student(String name, int eng, int math) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", eng=" + eng + ", math=" + math + "]";
	}
	
}
