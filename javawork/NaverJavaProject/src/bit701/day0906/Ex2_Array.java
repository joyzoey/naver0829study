package bit701.day0906;

public class Ex2_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//배열 선언시 초기값을 지정하는 경우
		int []arr= {5,8,10,4,20};//5개로 배열이 자동할당
		System.out.println("arr의 할당갯수 : "+arr.length);
		
		//출력
		System.out.println("**** 출력 1 ****");
		for (int n:arr) {
			System.out.println(n);
		}System.out.println();
		
		System.out.println("**** 출력 2 ****");
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("=".repeat(30));
		int []arr2;
		arr2=new int[] {3,6,8,10,30};//선언 후 나중에 값을 한꺼번에 지정할 경우
		for(int i=0; i<arr2.length; i++)
			System.out.printf("[%3d : %2d]", i, arr2[i]);
		System.out.println();
		for(int n:arr2)
			System.out.printf("%3d",n);
		System.out.println();
	}

}