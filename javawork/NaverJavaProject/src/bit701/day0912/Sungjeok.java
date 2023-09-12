package bit701.day0912;

public class Sungjeok {
	private String name;
	private int kor;
	private int eng;
	
	//생성자
	public Sungjeok(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	//getter
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}
	
}
