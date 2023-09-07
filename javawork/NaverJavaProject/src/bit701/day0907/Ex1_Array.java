package bit701.day0907;

import java.util.Scanner;
public class Ex1_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 처음에 인원수 count를 입력 후 그 인원수 만큼
		 * names kor eng 를 배열 할당한 후
		 * 인원수 만큼 이름, 국어점수, 영어점수를 입력하면
		 * 아래와 같이 출력
		 * 
		 * 번호 	이름	국어	영어	총점	평균
		 * ---------------------------------------------
		 * 1		김나혜	89		90		179		89.5
		 */
		
		Scanner sc=new Scanner(System.in);
		int count;
		
		System.out.print("할당할 갯수를 입력하세요.");
		count=Integer.parseInt(sc.nextLine());
		
		//배열할당
		String []names=new String[count];
		int []kor=new int[count];
		int []eng=new int[count];
		int []sum=new int[count];
		double[]ave=new double[count];
		
		
		//데이타입력
		
		
		for(int i=0;i<names.length;i++) {
			System.out.print(i+1+"번 이름은?");
			names[i]=sc.nextLine();
			System.out.print("\t"+(i+1)+"번 국어 점수 입력 : ");
			kor[i]=Integer.parseInt(sc.nextLine());
			if (kor[i]<0 || kor[i]>100) {
				System.err.println("0-100사이 점수로 입력바람!");
				i--;
				continue;
			}
			System.out.print("\t"+(i+1)+"번 영어 점수 입력 : ");
			eng[i]=Integer.parseInt(sc.nextLine());
			if (eng[i]<0 || eng[i]>100) {
				System.err.println("0-100사이 점수로 입력바람!");
				i--;
				continue;
			}
			sum[i]=kor[i]+eng[i];
			ave[i]=sum[i]/2.0;
			System.out.println();
			
					
		}	
		//출력
		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
		System.out.println("=".repeat(50));
		for (int i=0; i<names.length; i++) {
			System.out.println(i+1+"\t"+names[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+sum[i]+"\t"+ave[i]);
		}
	
		
	}

}
