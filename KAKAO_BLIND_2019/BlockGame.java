package Programmers.KAKAO_BLIND_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlockGame {

	public static void main(String[] args) {
		
		int[][] board = {
				// {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}
				// {0, 2, 0, 0}, {1, 2, 0, 4}, {1, 2, 2, 4}, {1, 1, 4, 4}
				// {2,2,0,0}, {1,2,0,0} , {1,2,0,0}, {1,1,0,0}
				// {0, 0, 0, 0, 0}, {1, 0, 0, 2, 0}, {1, 2, 2, 2, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}
				 {0,0,3,2}, 
				 {3,3,3,2}, 
				 {1,0,2,2}, 
				 {1,1,1,0}
		};
		
		System.out.println("result : " + solution(board));
		
		
	}
	
	static int[] posX = {1, -1, 0 ,0};
	static int[] posY = {0, 0, 1, -1};
	static int[][] boardSt;
	static int answer = 0;
	static int N;
	
	
	static List<Pair> findBlock(int value, Pair p){
		
		List<Pair> block = new ArrayList<>();
		block.add(p);
		
		Queue<Pair> q = new LinkedList<>();
		q.add(p);
		
		boolean[][] visited = new boolean[N][N];
		
		while (!q.isEmpty()) {
			
			Pair wk = q.poll();
			
			if(visited[wk.x][wk.y])
				continue;
			
			visited[wk.x][wk.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextX = wk.x + posX[i];
				int nextY = wk.y + posY[i];
				
				if (nextX >=0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY] && boardSt[nextX][nextY] == value) {
					Pair next = new Pair(nextX, nextY);
					q.add(next);
					block.add(next);
				}
			}
		}
		return block;
	}
	
	static void removeBlock(List<Pair> block) {
		for (int i = 0; i < block.size(); i++) {
			Pair p = block.get(i);
			boardSt[p.x][p.y] = 0; 
		}
	}
	
	
	public static int isPossible(List<Pair> emptyBlock) {
		
		int cnt = 0;
		
		for (int k = 0; k < emptyBlock.size(); k++) {
			
			Pair p = emptyBlock.get(k);
			
			if (boardSt[p.x][p.y] != 0 || !checkPossible(p)) {
				break;
			}
			cnt++;
		}
		
		return cnt;
	}
	

	public static int solution(int[][] board) {
		
		boardSt = board;
		N = board.length;

		gameStart();
		
		return answer;
	}
	
	static int gameStart() {
		
		int removeCnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int value = boardSt[i][j];
				if (value != 0) {
					
					List<Pair> block = findBlock(value, new Pair(i, j));
					List<Pair> emptyBlock = getEmptyList(block);
					
					if (isPossible(emptyBlock) == 2) {
						removeCnt++;
						answer++;
						removeBlock(block);
					}
				}
			}
		}
		if (removeCnt != 0)
			gameStart();
		
		
		return answer;
	}
	
	
	static List<Pair> getEmptyList(List<Pair> list){
		
		List<Pair> empties = new ArrayList<>();
		
		int[] visitX = new int[51];
		int[] visitY = new int[51];
		
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			Pair p = list.get(i);
			
			if (visitX[p.x] == 0) {
				x.add(p.x);
			}
			
			if (visitY[p.y] == 0) {
				y.add(p.y);
			}
			visitX[p.x]++;
			visitY[p.y]++;
		}
		
		List<Integer> two, three;
		boolean threeTwo = true;
		
		if (x.size() > y.size()) {
			three = x;
			two = y;
		} else {
			three = y;
			two = x;
			threeTwo = false;
		}
		
		int value = 0;
		for (int i = 0; i < 2; i++) {
			if (two.get(i) == 3) {
				continue;
			} else {
				value = two.get(i);
				break;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (threeTwo) {
				if (visitX[three.get(i)] == 1)
					empties.add(new Pair(three.get(i), value));
			} else {
				if (visitY[three.get(i)] == 1)
					empties.add(new Pair(value, three.get(i)));
			}
		}
		return empties;
	}
	
	static boolean checkPossible(Pair pos) {
		
		for (int i = 0; i < pos.x; i++) {
			if (boardSt[i][pos.y] != 0)
				return false;
		}
		return true;
	}

	// row를 기준으로 내림차순.
	// row의 바로 상단이 0일 때, 쭉~ 비어있으면 놓을 수 있다.
	static class Pair implements Comparable<Pair>{
		int x;
		int y;

		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.x == o.x ? this.y - o.y : this.x - o.x;
		}

		public String toString() {
			return "("+ x+", "+y+")\n";
		}
	}

}
