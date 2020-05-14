package Programmers.KaKaoFinal_2017;

import java.util.Arrays;

public class PlayStreet {

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
		
		// 현재 위치를 기준으로 오른쪽으로 갈 수 있는 경우의 수
		int[][] right = new int[m+1][n+1];
		// 현재 위치를 기준으로 아래로 갈 수 있는 경우의 수를 구해간다.
		int[][] down = new int[m+1][n+1];
		
		// 0,0부터 구해갈껀데,
		// row = 0 일때, 상단의 경우의수는 0이되어야 한다.
		// col = 0 일때, 좌측의 경우의수는 0이되어야 한다.
		// 첫줄을 모두0으로 채워주고 시작하고 , ( 1,1  )부터 m,n까지 값을 채워나간다.
		
		for( int i=1; i<=m; i++ ) {
			for( int j=1; j<=n; j++ ) {
				
				//현재위치의 값을 확인한다.
				int current = cityMap[i-1][j-1];
				
				if(current==0) {
					if(i==1 && j==1) { // 최초 0,0의 값에는 무조건 0이들어옴으로, 1,1의 경우에는 우측1, 아래1 갈 수 있다.
						right[i][j] = down[i][j] = 1;
					}else { // 0인 경우는 상단의 경우의 수, 좌측의 경우의 수를 합한 경우의 수가 된다.
						right[i][j] = right[i][j-1] + down[i-1][j];
						down[i][j] = right[i][j-1] + down[i-1][j];
					}
				}else if(current==1) {
					right[i][j]=0;
					down[i][j]=0;
				}else { // 2인 경우
					// 현재위치에서 오른쪽으로 갈 수 있는 경우의 수는, 좌측의에서 접근 했을 때의 경우의 수이다.
					right[i][j]=right[i][j-1];
					// 현재위치에서 아래쪽으로 갈 수 있는 경우의 수는, 상단에서 접근 했을 때의 경우의 수이다.
					down[i][j]=down[i-1][j];
				}
				
			}
		}
		
        
        for(int[] u : down ) {
        	System.out.println(Arrays.toString(u));
        }
		
		return right[m][n];
	}
}
