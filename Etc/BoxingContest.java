package Programmers.Etc;

import java.util.LinkedList;
import java.util.Queue;

public class BoxingContest {

	public static void main(String[] args) {
		int[][] puddles = {{2,2}};
		System.out.println(solution(4, 3, puddles));

	}
	
	static int[] X = {0, 1};
	static int[] Y = {1, 0};
    public static int solution(int m, int n, int[][] puddles) {
        
        boolean[][] visited = new boolean[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];
        
        // 징검다리 체크
        for(int[] pds : puddles) {
        	map[pds[0]][pds[1]] = -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,1,0));
        
        int min = 100001;
        int cnt = 0;
        
        while (!q.isEmpty()) {
        	
        	Pair p = q.poll();
        	
        	System.out.println("p.x : " + p.x + ", p.y : " + p.y);
        	
        	if (p.x == n && p.y == m) {
        		System.out.println("here");
        		if (p.w <= min) {
        			if (p.w < min) {
        				min = p.w;
        				cnt = 0;
        			}
        			cnt++;
        		}
        	}
        	if (visited[p.x][p.y])
        		continue;
        	
        	visited[p.x][p.y] = true;
        	
        	for (int i = 0; i < 2; i++) {
        		int nX = p.x + X[i];
        		int nY = p.y + Y[i];
        		
        		if (nX <= n && nY <= m && !visited[nX][nY] && map[nX][nY] != -1) {
        			q.add(new Pair(nX, nY, p.w + 1));
        		}
        	}
        }
        return cnt;
    }
    
	static class Pair {

		int x;
		int y;
		int w;

		Pair(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		public String toString() {
			return "[ x : " + x +",  y : " + y +", w : " + w +" ]";
		}
	}
    

}
