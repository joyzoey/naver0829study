package bit701.day0919;

import java.util.Arrays;

class Solution {
    public static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start;
        if(num/2==0) {
        	start=(total/num)-((num/2)-1);
        	System.out.println("짝수");
        }else {
        	start=(total/num)-(num/2);
        	System.out.println("홀수");
        } 
        
        for (int i = 0; i < num; i++) {
            answer[i] = start;
            start++;
        }
        return answer;
    }

    

    public static void main(String[] args) {
        int num = 4;
        int total = 14;
        int[] result = solution(num, total);

        System.out.println(Arrays.toString(result));
    }
}