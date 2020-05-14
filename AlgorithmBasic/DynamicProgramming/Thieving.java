package Programmers.AlgorithmBasic.DynamicProgramming;

public class Thieving {

	public static void main(String[] args) {
		
		int[] money = { 
				1,2,3,1
		};
		
		int result = solution(money);
		
		System.out.println(" Result : " + result );
	}
	
    public static int solution(int[] money) {
        
        // 마을은 동그랗게 배치되어있다.
        // n개의 마을을 털 때, 털을 수 있는 최대값을 구한다.
        // 모든 집을 대상으로 털어가기때문에, 2가지 경우를 고려한다.
        // 인접한 3개의 집을 털 때, 가능한 최대값은. 3번째집을 기준으로 1번+3번집을 털거나, 2번집만 터는 경우가 된다.
        
        // 1. 첫번째 집을 터는경우. > 이때는 마지막집을 털 수 없다.
        int[] dp = new int[money.length-1];
        dp[0]=dp[1]=money[0]; // 두번째 집은 털 수 없다.
        
        for( int i=2; i<dp.length; i++ ) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
        }
        
        // 2. 첫번째 집을 털지않는 경우. > 이때는 마지막집을 털 수 있다.
        int[] dp2 = new int[money.length];
        dp2[0]=0;
        dp2[1]=money[1];
        
        for( int i=2; i<dp2.length; i++ ) {
        	dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
        }
        
        // 첫번째 집부터 최대 마지막집 전까지턴 경우, 두번째 집부터 최대 마지막집까지 턴 경우의 최대 값 중 더 큰 값을 return한다.
        
        return Math.max(dp[money.length-2], dp2[money.length-1]);
    }

}
