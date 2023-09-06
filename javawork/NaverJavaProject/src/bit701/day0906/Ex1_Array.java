package bit701.day0906;

public class Ex1_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//교재 165
		//배열 : 연속된 형태로 데이타가 저장되는 형태
//				배열에는 같은 타입의 데이터만 저장이 가능하다
//				일괄적으로 처리하기 위해 배열을 사용
//				자바에서 하나의 배열은 하나의 객체로 인식된다
		
		//선언 방법1
		int []arr1=new int[5];//5개의 정수타입을 저장할 공간 확보,0으로 자동 초기화
		System.out.println("arr1의 할당갯수:"+arr1.length);//5
		
		//배열의 특정 번지에 값을 넣는 방법
		arr1[1]=10;
		arr1[4]=50;
		
		//출력1
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}System.out.println();
		
		//출력2
		for(int n:arr1) {
			System.out.println(n);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
