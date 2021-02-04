package Basic.AlgorithmBasic.DynamicProgramming;

import java.util.Arrays;

public class SeoutToKyongsan {

	// 자전거를 타는경우
	static int[] dp ;
	// 도보를 이용하는 경우
	static int[] dp2 ;

	static int bikeRemain = 0;
	static int walkRemain = 0;

	static int[][] travels ;
	static int max = 0 ;

	public static void main(String[] args) {

		int[][] travel ={
				 // {1000, 2000, 300, 700},{1100, 1900, 400, 900},{900, 1800, 400, 700},{1200, 2300, 500, 1200}
				// {500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}
				 {1,1,1,1} , {99,1000,1,1} , { 1,1,1,1 } 
		};

		int k = 100; // 3000 , 1650 , 100 (답 : 3)

		int result = solution2(k,travel);

		System.out.println(" result : " + result );

	}


	public static int solution(int K, int[][] travel ) {
		travels = travel ;
		calc(0,K,0);
		return max;
	}

	// 해당 index에서, 자전거 or 바이크를 선택했을 
	private static void calc( int index  , int K , int value ) {

		if( K < 0 ) return ;

		if( index == travels.length ) {
			max = Math.max(max, value);
			return ;
		}

		int[] t = travels[index];

		// 처음에 도보를 선택했을 때 나올 수 있는 최대 값구하기.
		calc(index+1,K-t[0],value+t[1]);
		// 처음에 자전거를 선택했을 때 나올 수 있는 최대 값구하기.
		calc(index+1,K-t[2],value+t[3]);

		return ;
	}

	public static int solution2(int K, int[][] travel) {

		// n번째 구간에 도달 할 수 있는 시간에 모금액을 기록한다.
		int[][] dp= new int[travel.length][K+1];
		
		// n번째 구간에 도달 할 수 있는 시간에 모금액을 구할 때,
		// [ n-1번째 구간에 도달한 시간 + n번째 구간에 도달한 시간 ]이 K를 넘어가선 안된다.
		
		// 초기값 지정, 같은 조건을 반복하기 위해 0번째 구간에 1번째 구간에 도달할 수 있는 시간과, 모금액을 기록한다.
		dp[0][travel[0][0]] = travel[0][1]; // 걸어가는 경우
		dp[0][travel[0][2]] = travel[0][3]; // 자전거 타는 경우
		
		// 해당 구간에 도달 할 수 있는 경우를 구하려면
		// n-1번째에 도달할 수 있는 모든 시간대에, 도보, 자전거를 탔을 때 max값을 구해주어야 한다.
		for ( int i=1; i< travel.length; i++ ) {
			for ( int t=0; t <= K ; t++ ) {
				
				// n-1번째에 도착한 적이 없는 시간이면 continue
				if(dp[i-1][t]==0) continue;				
				
				// 도보를 이용할 수 있는 경우.
				// [ n-1번째 구간에 도달한 시간 + n번째 구간에 도달한 시간 ] 이 K를 넘어가선 안된다.
				if( K >= t + travel[i][0] ) {
					// 해당 구간에 도착할 수 있는 시간대에 모금액을 기록한다.
					// 1~최대 K+1까지의 시간대를 보기 때문에, 같은 구간에 같은시간대가 여러번 나올 수가있다. 그럴 때를 고려하여 max를 사용한다.
					dp[i][t + travel[i][0]] = Math.max(dp[i][t + travel[i][0]], dp[i-1][t]+travel[i][1]);
					int a = dp[i][t + travel[i][0]];
				}
				// 자전거를 이용할 수 있는경우
				if( K >= t + travel[i][2] ) {
					dp[i][t + travel[i][2]] = Math.max(dp[i][t + travel[i][2]], dp[i-1][t]+travel[i][3]);
					int a = dp[i][t + travel[i][2]];
				}
				
				// 작다면, 이전 까지의 경로는 봐서는 안된다.
				if ( K < t + travel[i][0] ||  K < t + travel[i][2] ) dp[i-1][t]=0;			}
		}
		
		int[] arr = dp[travel.length-1];
		Arrays.sort(arr);
		
		return arr[arr.length-1] ;
	}





}//class
