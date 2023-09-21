package bit701.day0914;

public class Student {
	
	//필드선언
	private String name;
	private int score;
	private String blood;
	
	//생성자 오버로딩	
	public Student() {}

	public Student(String name, int score, String blood) {
		super();
		this.name = name;
		this.score = score;
		this.blood = blood;
	}

	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}
	
}