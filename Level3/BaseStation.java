package Programmers.Level3;

public class BaseStation {

	public static void main(String[] args) {
		
		//아파트의 개수
		int n = 4;
		// 기지국이설치된 아파트
		int[] stations = {
				2
		};
		// 전파의 도달 거리 
		int w = 1;
		
		int result = solution(n,stations,w);
		
		System.out.println(" result : " + result );
	}
	
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int start = 1;
        int end = 0;
        
        int possible = (w*2) + 1 ;
        
        for ( int i=0; i<stations.length; i++ ) {
        	
        	int station = stations[i];
        	
        	end = station-w-1;
        	int dis = end-start+1;
        	
        	if( dis < 1 ) dis = 0;
        	
        	answer+=(dis/possible);
        	
        	if( (dis%possible) != 0 ) answer++; 
        	
        	start = station+w+1;
        }
        
        if( start < n ) {
        	
        	int dis = n - start + 1 ;
        	answer += (dis/possible);
        	if ( dis%possible != 0 ) answer++; 
        }
        
        if ( start == n ) answer++;
        
        return answer;
    }

}
