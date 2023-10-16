package bit701.day1011;

class Solution {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int denom=denom1*denom2;
        int numer=numer1*denom2+numer2*denom1;
        int min=Math.min(denom,numer);

        for(int i=2; i<=min; i++){
            if(denom%i==0 && numer%i==0){
                denom/=i;
                numer/=i;
                i=1;
            }
        }
        answer[0] = numer;
        answer[1] = denom;
        
   
        return answer;
    }
}


public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution ex = new Solution();
		int[] result = ex.solution(1, 2, 3, 4);
		
		System.out.println(result[0] + ", " + result[1]);
	}

}
