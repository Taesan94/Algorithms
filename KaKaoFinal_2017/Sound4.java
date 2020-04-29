package Programmers.KaKaoFinal_2017;

public class Sound4 {

	public static void main(String[] args) {

		int n = 2147483647;
		int result = solution(n);

		System.out.println("result : " + result );

	}

	public static int solution(int n) {
		int result = find(n-2,2);
		return result;
	}
	
	// 찾아야하는 수, plus의 개수.
	private static int find(int n,int plus) {
		
		int result = 0;
		// *가 나올 수 있는 경우의 수는 plus/2 이다.
		// 그리고 찾아야 하는 수 n이 *로 만들 수 있는 최소 값보다 작은 경우는 고려할 필요가 없다.
		if( n < Math.pow(3, plus/2) ) return 0;
		
		// n=3, plus=2 일 때는 만들 수 있다.
		if( n==3 && plus==2 ) return 1;
		
		// *가 나올 수 있는 경우는, n을3으로 나눌 수 있을 때이다. 나눌 수 없다면 plus를 증가 시켜준다.
		if( n%3==0 && plus>=2 ) result += find(n/3,plus-2);
		
		// 나눌 수 있던 없던, plus를 증가시키는 경우의 수는 모두 체크해야 한다.
		result += find(n-1,plus+1);
		
		return result;
		
	}


}
