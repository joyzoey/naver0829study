package bit701.day0905;

public class ex96_star_p139_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//늘어나는 별
//		for(int i=1; i<=5; i++) {
//			for (int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//줄어드는 별
//		for(int i=1; i<=5; i++) {
//			for (int j=1; j<=(6-i); j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//별군단 사이 숫자
		for(int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				if(i==j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		
	}

}
