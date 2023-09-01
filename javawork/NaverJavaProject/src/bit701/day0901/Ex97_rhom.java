package bit701.day0901;

public class Ex97_rhom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		int n=10;
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<i+1; j++) {
//				System.out.print("*");
//			}System.out.println();
//		}
//		
//		String star="*";
//		for(int i=0; i<5; i++) {
//			System.out.printf("%5s\n",star);
//			star=star+"*";
//		}
//		
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<4-i; j++) {
//				System.out.print(" ");
//			}
//			for(int j=0; j<i+1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
		
		
		int n=7;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-(i+1); j++) {
				System.out.print(" ");
			}
			for(int j=0; j<1+2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	

}
}
