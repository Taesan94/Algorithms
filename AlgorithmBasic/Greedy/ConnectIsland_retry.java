package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;

public class ConnectIsland_retry {

	public static void main(String[] args) {
		
		int n = 6; // 4;
		
		int[][] costs = {
				{2,5,1},
				{5,4,2},
				{3,4,3},
				{1,0,4},
				{2,1,5}
				//{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
		};	
		System.out.println("result : " + solution(n, costs));
	}
	
	static void print(int[][] arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	static int[][] islands;
	static int[] parents; // 각 섬의 부모를 기록하고 있는다.
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        islands = new int[n][n];
        parents = new int[n];
        
        // 1. 가중치가 낮은 순서대로 먼저 정렬.
        Arrays.sort(costs , (o1, o2) -> {
        	return o1[2] - o2[2];
        });
        
        // 부모의 초기 값은 자기 자신으로.
        for (int i = 0; i < n; i++) {
        	parents[i] = i;
        }
        
        // 2. 두 섬이 연결되어있지 않다면 연결.
        for (int[] cost : costs) {
        	
        	int from = cost[0];
        	int to = cost[1];
        	int value = cost[2];
        	
        	// 연결되어 있지않다면, 합해준다.
        	
        	// 이미 연결되어 있다면 처리하지 않는다.
        	if(getParent(from) == getParent(to)) {
        		continue;
        	} else {
        		union(from, to);
        		// 합하고 비용을 더해준다.
        		answer += value;
        	}
        }
        
        System.out.println(Arrays.toString(parents));
        
        return answer;
    }
    
    // 가중치 기준으로 연결하기 때문에, 멀리 떨어진 섬부터 연결 될 수 있다.
    // 즉, 섬을 연결해나가는 과정에서 부모 섬의 위치를 정확하게 파악하기위해선, 재귀해야 한다.
    static int getParent(int island) {    	
    	if(parents[island] == island)
    		return island;
    	
    	return getParent(parents[island]);
    }
    
    static void union(int from, int to) {    	
    	from = getParent(from);
    	to = getParent(to);
    	
    	parents[to] = from;
    	// to의 부모는 from의 부모가 되어야 한다.
//    	if (from < to)
//    		parents[to] = from;
//    	else
//    		parents[from] = to;
    }

}
