package Programmers.Level2_Retry1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

	public static void main(String[] args) {
		
		int[][] p1 = {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}
		};
		System.out.println(Arrays.toString(solution(6, 4, p1)));
	}
	
	static boolean[][] visited;
	static int M,N;
	static int[] X = {0, 0, 1, -1};
	static int[] Y = {1, -1, 0 ,0};
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        
        visited = new boolean[m][n];
        M = m;
        N = n;
        
        // 전체탐색. 0이 아닐 때 같은 색깔을 모두 방문.
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (!visited[i][j] && picture[i][j] != 0) {
        			int size = bfs(new Pair(i, j), picture[i][j], picture);
        			numberOfArea++;
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
        		}
        		
        	}
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(Pair start, int color, int[][] picture) {
    	
    	Queue<Pair> q = new LinkedList<>();
    	q.add(start);
    	
    	int cnt = 0;
    	while (!q.isEmpty())
    	{
    		Pair p = q.poll();
    		
    		if (visited[p.x][p.y])
    			continue;
    		
    		visited[p.x][p.y]= true; 
    		
    		cnt++;
    		
    		for (int i = 0; i < 4; i++) {
    			int nX = p.x + X[i];
    			int nY = p.y + Y[i];
    			
    			if (nX >= 0 && nX < M && nY >= 0 && nY < N) {
    				if (!visited[nX][nY] && picture[nX][nY] == color)
    					q.add(new Pair(nX, nY));
    			}
    		}
    	}
    	return cnt;
    }
    
    static class Pair {
    	int x;
    	int y;
    	
    	Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }

}
