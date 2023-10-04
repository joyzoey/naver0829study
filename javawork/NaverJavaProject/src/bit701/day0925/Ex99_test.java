package bit701.day0925;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char [] charArray = a.toCharArray();
        for(int i=0; i<charArray.length; i++)
        {
        	char b=charArray[i];
        	if(Character.isLowerCase(b)) {
        		charArray[i]=Character.toUpperCase(b);
        	}else if(Character.isUpperCase(b)) {
        		charArray[i]=Character.toLowerCase(b);
        	}
        }
        String c= new String(charArray);
        System.out.println(c);
    }
}


public class Ex99_test {
}
