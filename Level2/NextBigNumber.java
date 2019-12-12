package Programmers.Level2;

public class NextBigNumber {

	public static void main(String[] args) {

		int a = 78;
		
		int answer = solution(a);
		
		System.out.println(answer);

	}

	public static int solution(int n) {

		int nCnt = Integer.bitCount(n);
		
		for ( int i = n+1 ; i < 10000001; i++ ) {
			
			int nextCnt = Integer.bitCount(i);
			if ( nCnt == nextCnt ) return i;
		}
		
		return 0 ;

	}

}
