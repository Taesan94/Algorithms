package Programmers.KAKAO_BLIND_2020;

import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	
	static int[] spin1X = {-1, 1, -1, 1};
	static int[] spin1Y = {-1, -1, 1, 1};	
	static int[] spin2X = {-1, -1, 1, 1};
	static int[] spin2Y = {-1, 1, -1, 1};


	public static void main(String[] args) {
		int[][] board = {
				// {0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}
				// {0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{1, 1, 1, 1, 1, 1, 1, 0, 0}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 1, 1, 1, 1, 0, 0}, 
				{0, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{0, 0, 1, 1, 1, 1, 1, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 0}
				};

		
		int result = solution(board);
		
		System.out.println("result : " + result);

	}
	
	static int[][] staticBoard;
	static int[][][][] visited;
	static int answer = 1;
	static int N = 0;
    public static int solution(int[][] board) {
        
    	staticBoard = board;
        N = board.length;
        visited = new int[N][N][N][N];
        
        bfs();        
                   
        return answer;
    }
    
    static void bfs() {
    	Queue<Robot> q= new LinkedList<Robot>();
    	Queue<Robot> q2= new LinkedList<Robot>();
    	
    	Robot start = new Robot(new Pair(0,0), new Pair(0,1));
    	
    	q.add(start);
    	visited[0][0][0][1] = 1;
    	
    	while(!q.isEmpty()) {
    		Robot r = q.poll();
    		
    		Pair p1 = r.part1;
    		Pair p2 = r.part2;
    		    		    		    		
    		// 4방위 for문 .. 가능한거 add
    		for (int i=0; i < 4; i++) {
    			
    			Pair nextP1 = new Pair(p1.x + X[i], p1.y + Y[i]);
    			Pair nextP2 = new Pair(p2.x + X[i], p2.y + Y[i]);
    			
    			if (isPossible(nextP1) && isPossible(nextP2)) {
    				
        			boolean[] check = visitedAndAnswer(nextP1, nextP2);
        			
        			if (check[0]) {
        				q2.add(new Robot(nextP1, nextP2));
        			}
    				
    				if (check[1]) {
    					return ;
    				}
    			}
    		}

    		// 가로로 있을 때
    		if (Math.abs(p1.y - p2.y) == 1) { //&& spinCheck(q2, p1, p2, spin1X, spin1Y, -1, 0)) {
    			System.out.println("가로 :" + p1.toString() +", "+ p2.toString());
    			if (spinCheck(q2, p1, p2, spin1X, spin1Y, -1, 0))
    				return;
    		} else if (Math.abs(p1.x - p2.x) == 1) {//&& spinCheck(q2, p1, p2, spin2X, spin2Y, 0, -1)) { // 세로로 있을 때
    			System.out.println("세로 :" + p1.toString() +", "+ p2.toString());
    			if(spinCheck(q2, p1, p2, spin2X, spin2Y, 0, -1))
    				return;
    		}
    		
    		if (q.isEmpty() && !q2.isEmpty()) {
    			System.out.println(q2.toString());
    			q.addAll(q2);
    			q2.clear();
    			answer++;
    		}
    	}
    	System.out.println("empty");
    }
    
    static boolean spinCheck(Queue<Robot> q2, Pair p1, Pair p2, int[] spinX, int[] spinY, int spinPosX, int spinPosY) {
    	for (int i=0; i < 4; i++) {
			Pair move = p2;
			Pair stay = p1;
			
			if (i > 1) {
				move = p1;
				stay = p2;
			}
			
			
			Pair next = new Pair(move.x + spinX[i], move.y + spinY[i]);
			Pair spinPos = new Pair(move.x + spinPosX, move.y + spinPosY);
			spinPosX *= -1;
			spinPosY *= -1;
			
			if (isPossible(next) && isPossible(spinPos)) {        				
				boolean[] check = visitedAndAnswer(stay, next);
				
      			if (check[0]) {
      				System.out.println("add .. " + stay.toString() +", " + next.toString());
      				q2.add(new Robot(stay, next));
    			}
				
				if (check[1]) {        							
					return true; 
				}
			}    				
		}    	
    	return false;
    }
    
    static boolean isPossible(Pair part) {
    	boolean possible = false;
    	
		int x = part.x;
		int y = part.y;

    	if (x >= 0 && x < N && y >= 0 && y < N) {
    		if (staticBoard[x][y] != 1)
    			possible = true;
    	}
    	return possible;    	
    }
    
    static boolean[] visitedAndAnswer(Pair p1, Pair p2) {
    	
    	boolean[] result = new boolean[2];
    	
    	if (visited[p1.x][p1.y][p2.x][p2.y] == 0 && visited[p2.x][p2.y][p1.x][p1.y] == 0) {
    		visited[p1.x][p1.y][p2.x][p2.y] = 1;
    		visited[p2.x][p2.y][p1.x][p1.y] = 1;
    		result[0] = true;
    	}
    	
    	if ((p1.x == N -1 && p1.y == N - 1) || (p2.x == N - 1 && p2.y == N - 1)) {
    		result[1] = true;
    	}
    	
    	return result;
    	
    }
       
    static class Robot {
    	Pair part1;
    	Pair part2;
    	
    	Robot(Pair part1, Pair part2) {
    		
    		if (part1.x - part2.x < 0 || part1.y - part2.y < 0) {
    			this.part1 = part1;
    			this.part2 = part2;
    		} else {
    			this.part1 = part2;
        		this.part2 = part1;    			
    		}
    	}
    	
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return part1.toString() + " && " + part2.toString() + " ... ";
    	}
    }
    
    static class Pair {
    	int x;
    	int y;
    	
    	Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return "("+x+", "+y+")";
    	}
    }

} // class
