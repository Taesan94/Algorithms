package Programmers.FindMaester;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapMShortistDistance {

	public static void main(String[] args) {
		
		int[][] maps = {
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
				// {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}	
				// {1, 1},{1, 1},{0, 1}
		};
		
		System.out.println("result : "+ solution(maps));

	}
	
	static int N, M;
	static int answer = 1;
	static int[] posX = {0, 0, 1, -1};
	static int[] posY = {1, -1, 0, 0};
	static boolean possible = false;
	
    public static int solution(int[][] maps) {
    	
        N = maps.length;
        M = maps[0].length;
        
        return bfs(new Pair(0, 0, 1), maps);
    }
    
    static int bfs(Pair start, int[][] maps) {
    	
    	Queue<Pair> q = new LinkedList<>();
    	
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		
    		Pair p = q.poll();
    		
    		if (p.x == N - 1 && p.y == M - 1) {
    			return p.distance;
    		}
    		
    		if (maps[p.x][p.y] == 0) {
    			continue;
    		}
    		
    		maps[p.x][p.y] = 0; 
    		
    		for (int k = 0; k < 4; k++) {
    			int nX = p.x + posX[k];
    			int nY = p.y + posY[k];
    			
    			if (nX >= 0 && nX < N && nY >= 0 && nY < M && maps[nX][nY] == 1) {
    				q.add(new Pair(nX, nY, p.distance + 1));
    			}
    		}
    	}
    	
    	return -1;
    }
    
    static class Pair {
    	
    	int x;
    	int y;
    	int distance;
    	
    	Pair(int x, int y, int distance){
    		this.x = x;
    		this.y = y;
    		this.distance = distance;
    	}
    	
    	public String toString() {
    		return "x : " + x +", y : " + y ;
    	}
    	
    }

}
