package bit701.day0911;

public class Ex99_199p8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=0, num=0;
		int[][] array= {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		for(int i=0; i<array.length;i++) {
			num+=array[i].length;
			for (int j=0; j<array[i].length; j++) {
				sum+=array[i][j];
			}
		}
		System.out.println("합:"+sum+"\n평균:"+(double)sum/num);
		
	}

}
