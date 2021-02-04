package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9372 {
	
	static int[] parents; // 각 섬의 부모를 기록하고 있는다.

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		for (int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.valueOf(st.nextToken());
			
			parents = new int[N + 1];
			
	        for (int a = 1; a <= N; a++) {
	        	parents[a] = a;
	        }
			
			int M = Integer.valueOf(st.nextToken());
			
			int cnt = 0;
			
			for (int j = 0; j < M; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				int v1 = Integer.valueOf(st.nextToken());
				int v2 = Integer.valueOf(st.nextToken());
				
	        	// 이미 연결되어 있다면 처리하지 않는다.
	        	if(getParent(v1) == getParent(v2)) {
	        		continue;
	        	} else {
	        		union(v1, v2);
	        		// 합하고 비용을 더해준다.
	        		cnt++;
	        	}
			}
			System.out.println(cnt);
		}
	}
	
    static int getParent(int island) {    	
    	if(parents[island] == island)
    		return island;
    	
    	return getParent(parents[island]);
    }
    
    static void union(int from, int to) {
    	
    	from = getParent(from);
    	to = getParent(to);
    	// to의 부모는 from의 부모가 되어야 한다.
    	parents[to] = from;
    }

}
