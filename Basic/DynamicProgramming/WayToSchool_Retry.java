package Basic.AlgorithmBasic.DynamicProgramming;

public class WayToSchool_Retry {

	public static void main(String[] args) {
		int m = 4;
		int n =3;
		int[][] puddles = {
				{2,2}
		};
		int result = solution(m,n,puddles);
		
		System.out.println(" result : " + result );
	}
	
    public static int solution(int m, int n, int[][] puddles) {
    	
    	// 지도를 만든다. row = n , col = m 
    	int[][] map = new int[n+1][m+1];
    	
    	// 웅덩이는 따로 표시해준다.
    	for(int[] puddle : puddles ) 
    		map[puddle[1]][puddle[0]]=-1;
    	
    	// 1,1은 시작점을 1로만들기위해서
    	map[1][0] = 1 ;
    	
    	// 지도를 탐색하면서, 현재위치에 도달할 수 있는 경우의 수를 기록한다.
    	for( int i=1; i<=n; i++ ) {
    		for ( int j=1; j<=m; j++ ) {
    			if( map[i][j]==-1) map[i][j]=0;
    			else map[i][j] = ( map[i-1][j] + map[i][j-1] ) % 1000000007; // 상단, 좌측 더하기
    		}
    	}
    	
    	return map[n][m];
    }
        

}
