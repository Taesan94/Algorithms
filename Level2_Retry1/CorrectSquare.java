package Programmers.Level2_Retry1;

import java.math.BigInteger;

public class CorrectSquare {

	static int INF = 100000000;
	public static void main(String[] args) {
		
		System.out.println("check 1 : " + (long)(INF * INF));
		System.out.println("check 2 : " + (long)INF * (long)INF);
		System.out.println("check 3 : " + INF * (long)INF);
		System.out.println("check 4 : " + (long)INF * INF);
		
		
		long result = solution(8, 12);
		System.out.println(result);
	}

    public static long solution(int w, int h) {
    	long answer = 0;
        int gcd = getGcd(w,h);
        
        // 최대 수 1억임으로, 곱할 때 숫자 주의하기.....
        answer = ((long)w * (long)h) - (w + h - gcd);
        return answer;
    }

    // 유클리드 호제법을 사용하여 최대공약수 구하기
    static int getGcd(int n1, int n2) {
    	while (n2 != 0) {
    		int n3 = n1 % n2;
    		n1 = n2;
    		n2 = n3;
    	}
    	return n1;
    }
    
}
