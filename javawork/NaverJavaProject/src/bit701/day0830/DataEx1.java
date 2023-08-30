package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//줄넘김 탭넘김 실습
		System.out.print("apple\t");
		System.out.print("apple\n");
		System.out.print("apple");
		System.out.println("apple\n");

		//변환기호실습
		int age=29;
		double weight=100.5;
		char blood='A';
		String name="나혜";
		
		//출력샘플1
		System.out.printf("이름:%s\n",name);
		System.out.printf("나이:%d세\n",age);
		System.out.printf("혈액형:%c\n",blood);
		System.out.printf("몸무게:%fkg\n",weight);
		System.out.printf("몸무게:%6.1fkg\n\n",weight);
		
		//출력샘플2
		System.out.printf("이름:%s\n나이:%d세\n혈액형:%c\n몸무게:%fkg\n",name,age,blood,weight);

	}

}