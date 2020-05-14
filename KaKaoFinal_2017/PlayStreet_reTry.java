package Programmers.KaKaoFinal_2017;

import java.util.Arrays;

public class PlayStreet_reTry {

	public static void main(String[] args) {
		int m=3;
		int n=6;

		int[][] cityMap ={
				{0, 2, 0, 0, 0, 2},{0, 0, 2, 0, 1, 0},{1, 0, 0, 2, 2, 0}
				// {0,0,0},{0,0,0},{0,0,0}
				// {0,0,0},{0,1,0},{0,0,0}
		};
		int result = solution(m,n,cityMap);

		System.out.println(result);

	}
	
    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        
        // 현재 좌표에 위에서 아래로 도달하는 경우의 수.
        int[][] up =  new int[m+1][n+1];
        // 현재 좌표에 왼쪽에서 오른쪽으로 도달하는 경우의 수.
        int[][] left = new int[m+1][n+1];
        
        up[1][0] = left[1][0] = 1 ;
        
        for( int i=1; i<=m; i++ ) {
        	for( int j=1; j<=n; j++ ) {
        		
        		int current = cityMap[i-1][j-1];
        		
        		if( current==0 ) {
        			up[i][j]=(up[i-1][j] + left[i][j-1])%MOD;
        			left[i][j]=(up[i-1][j] + left[i][j-1])%MOD;
        		}else if ( current==1 ) {
        			up[i][j]=left[i][j]=0;
        		}else {
        			up[i][j] = up[i-1][j]%MOD;
        			left[i][j] = left[i][j-1]%MOD;
        		}
        	}
        }
        return up[m][n];
    }

}
