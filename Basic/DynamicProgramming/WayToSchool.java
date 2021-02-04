package Basic.DynamicProgramming;

import java.util.Arrays;

public class WayToSchool {

	public static void main(String[] args) {
		int m = 4;
		int n =3;
		int[][] puddles = {
				{2,2},{3,2}	
		};
		int result = solution(m,n,puddles);
		
		System.out.println(" result : " + result );
	}
	
    public static int solution(int m, int n, int[][] puddles) {
        
        // m = col, n=row
        int[][] map = new int[n+1][m+1];
        // 해당 위치에 도달할 수 있는 경우의 수를 구해나간다.
        int[][] dp = new int[n+1][m+1];
        
        // 웅덩이 체크
        for( int[] puddle : puddles ) 
        	map[puddle[1]][puddle[0]] = -1;
        
        // 시작위치를 1로 셋팅하기 위해서., dp[0,1]해도 됨.
        dp[1][0]=1;
        
        // 이게 최솟값을 보지않아도 되는이유가..
        
        // 시작점 ( 1,1 ) 에서 도착점 ( n,m ) 까지갈 때,
        // 무조건 우측, 아래로만 이동을 할 수 있기때문에,
        // 도달하는 경우가 반드시 최소이동거리가 된다.
        // 그렇기 때문에, ( n,m ) 까지 도달가능한 경우의 수를 구해주면, 자연스럽게 집에서 학교까지 갈 수 있는 최단경로의 개수가 된다.
        for ( int i=1; i<=n; i++ ) {
        	for( int j=1; j<=m; j++ ) {
        		if(map[i][j]==-1) // 웅덩이인경우
        			dp[i][j]=0;
        		else
        			dp[i][j] =(dp[i-1][j] + dp[i][j-1]) % 1000000007 ;
        	}
        }
        
        for(int[] d : dp ) {
        	System.out.println(Arrays.toString(d));
        }
        
        return dp[n][m];
    }

}
