package bit701.day0830;

public class ExamEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String snum= args[0];
		int num=Integer.parseInt(snum);
		int num1=num/10;
		int num2=num%10;
		
		if (num1==num2) {
			System.out.println("yes!\n10의 자리와\n1의 자리가\n같습니다.");
		
		} else {
			System.out.println("no!\n10의 자리와\n1의 자리가\\n같지않습니다.");
		}
	}

}
