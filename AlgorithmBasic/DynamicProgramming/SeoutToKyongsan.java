package Programmers.AlgorithmBasic.DynamicProgramming;

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
				{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}
		};

		int k = 1650; // 3000 , 1650

		int result = solution2(k,travel);

		System.out.println(" result : " + result );

	}

	public static int solution(int K, int[][] travel) {
		int answer = 0;

		// 1. 도보, 자전거로 갈 수 있는 거리를 먼저 계산한다.

		for( int[] t : travel ) {
			walkRemain+=t[0];
			bikeRemain+=t[2];
		}

		// 자전거를 타는경우
		int[] dp = new int[travel.length+1];
		// 도보를 이용하는 경우
		int[] dp2 = new int[travel.length+1];

		// 최적해를 구해가면서 k를 감소시킬것이다.
		for( int i=1; i<= travel.length; i++ ) {

			int[] t =travel[i-1];

			int walkTime = t[0];
			int bikeTime = t[2];
			int walkValue = t[1] ;
			int bikeValue = t[3];

			//System.out.println( " bikeRemain : " + bikeRemain +", walkRemain : " + walkRemain +", K : " + K + ", walkTime : " + walkTime +", bikeTime : " + bikeTime );

			// 도보를 이용해도 된다면.
			if ( K-walkTime >= walkRemain ) {
				dp[i] = Math.max(dp[i-1], dp2[i-1]) + walkValue;
			}

			// 자전거를 이용해도 된다면.
			if ( K-bikeTime >= bikeRemain ) {
				dp2[i] = Math.max(dp[i-1], dp2[i-1]) + bikeValue;
			};

			bikeRemain -= bikeTime;
			walkRemain -= walkTime;

			System.out.println(i +"번 째 answer : " + answer );
		}

		for( int i=1; i < dp.length; i++ ) {
			System.out.println( " dp : " + dp[i] + ", dp2 : " + dp2[i]);
		}

		return Math.max(dp[travel.length], dp2[travel.length]);
	}
	
	public static int solution2(int K, int[][] travel ) {
		travels = travel ;
		calc(0,K,0);
		return max;
	}
	
	private static void calc( int index  , int K , int value ) {
		
		if( K < 0 ) return ;
		
		if( index == travels.length ) {
			max = Math.max(max, value);
			return ;
		}
		
		int[] t = travels[index];
		
		int walkTime = t[0];
		int bikeTime = t[2];
		int walkValue = t[1] ;
		int bikeValue = t[3];
		
		// 처음에 도보를 선택했을 때 나올 수 있는 최대 값구하기.
		calc(index+1,K-walkTime,value+walkValue);
		
		// 처음에 자전거를 선택했을 때 나올 수 있는 최대 값구하기.
		calc(index+1,K-bikeTime,value+bikeValue);
		
		return ;
	}
	
	

}
