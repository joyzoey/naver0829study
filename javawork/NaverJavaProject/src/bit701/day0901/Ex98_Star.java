package bit701.day0901;

public class Ex98_Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=5;
		for(int i=0; i<a*2; i+=2) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
		for(int m=a*2-3; m>0; m-=2) {
			for(int n=1; n<m; n++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
				
		
	}

}
