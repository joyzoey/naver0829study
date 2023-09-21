package bit701.day0914;

public class Ex1_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr= {10,20,30};
		for(int i=0; i<=arr.length; i++)
		{
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열번지를 벗어났어요:"+e.getMessage());
			}
		}
		System.out.println("정상종료.");
	}

}
