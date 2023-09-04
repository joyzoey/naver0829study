package bit701.day0904;

public class ex99_rohm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 20;
		int star = 1;
		
			for(int j=1; j< max; j++) {
				star = (j == 1 || j == max) ? 1 : ((max/2) < j ? star -2 : star + 2);
				System.out.println("    " + " ".repeat(Math.abs((max / 2) - j)) + ("*".repeat(star)));
			}
		
	}

}
