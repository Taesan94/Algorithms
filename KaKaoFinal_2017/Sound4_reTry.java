package Programmers.KaKaoFinal_2017;

public class Sound4_reTry {

	public static void main(String[] args) {

		int n = 13;
		int result = solution(n);

		System.out.println("result : " + result );

	}

	public static int solution(int n) {
		int result = 0;
		
		find(n-2,2);
		
		return result;
	}
	
	// 같은 패턴이 반복되기 때문에, +를 하나씩 빼주는 경우를 확인하면서
	// +가 2개일 때, 숫자 n이 3으로 나누어진다면 n/3을 가지고 확인한다.
	// 만일 +의 개수가 늘어나는데 계속해서 3으로 나눌 수 없는 경우가 발생하면 종료 한다.
	
	// n = 찾고있는 수, plusCnt는 +가 나온횟수.
	static int find(int n, int plusCnt) {
		
		int result = 0;
		
		// ++만큼 *가 나와야하는데, 이게 성립할려면 n은 *가 필요한 만큼의 제곱수보다 커야한다.
		if ( n < Math.pow(3,plusCnt/2) ) return 0;
		
		// n을 3으로 나누거나, -2씩 계산하기 된다.
		// 4단고음의 특성상 시작은 반드시 3이다, 고로 n=3인 경우면 시작점이라는 경우이고, 이 때 3단고음이 성립하려면 ++는 반드시2개가 존재해야 한다.
		if( n==3 && plusCnt==2 ) return 1;
		
		// 만약 n이 3으로 나누어지는 경우라면, *를 사용해준다.
		if( n%3==0 && plusCnt >=2 ) result+=find(n/3,plusCnt-2);
		
		// 기본적으로 +를 하나씩 셈해가야한다.
		find(n-1,plusCnt+1);
		
		return 0;
		
	}
}