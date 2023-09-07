package bit701.day0907;

public class Ex2_Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//배열 생성 첫번째 방법
		int [][]arr=new int[2][3];
		
		//배열 확인
		System.out.println("행갯수:"+arr.length);
		System.out.println("0번행의 열갯수:"+arr[0].length);
		System.out.println("1번행의 열갯수:"+arr[1].length);
		System.out.println("첫번째 배열 출력");
		arrayWrite(arr);
		
		//배열값 바꾸기
		arr[0][1]=5;
		arr[1][1]=6;
		System.out.println("변경된 첫번째 배열 출력");
		arrayWrite(arr);
		
		//두번째 방법
		int [][]arr2= {
				{1,2},{3,4,5},{1,2,3,4}
		
		};//0번행 열갯수2 1번행 3 2번행 4
		System.out.println("두번째 배열 출력");
		arrayWrite(arr2);
		
		//세번째 방법
		int [][]arr3;
		arr3=new int[][] {{1,2},{1,2,3},{4,5,6,7}};
		System.out.println("세번째 배열 출력");
		arrayWrite(arr3);
		
	}	
	
	public static void arrayWrite(int [][]arr) {
		System.out.println("=".repeat(50));
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.printf("[%d][%d]=%d   ",i,j,arr[i][j]);
			}System.out.println();
		}System.out.println("=".repeat(50));
	}

}
