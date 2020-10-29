package Programmers.Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MostDistanceNode {

	public static void main(String[] args) {
		
		int n = 6;
		int[][] vertex = {
				{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}
		};
		
		System.out.println(solution(n, vertex));
		
	}
	
	static int INF = 50001;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] distances = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
        	Arrays.fill(graph[i], INF);
        	distances[i] = INF;
        }
        distances[1] = 0;
        
        for (int[] e : edge) {
        	graph[e[0]][e[1]] = 1;
        	graph[e[1]][e[0]] = 1;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        boolean[] visited = new boolean[n + 1];
        
        while (!pq.isEmpty()) {
        	int curr = pq.poll().v;
        	
        	if (visited[curr])
        		continue;
        	visited[curr] = true;
        	
        	int[] adjArr = graph[curr];
        	
        	for (int i = 1; i <= n; i++) {
        		if (!visited[i] && distances[curr] + adjArr[i] < distances[i]) {
        			distances[i] = distances[curr] + adjArr[i];
        			pq.add(new Pair(i, distances[i]));
        		}
        	}
        }
        
        Arrays.sort(distances);
        
        int max = 0;
        for (int j = distances.length -1; j >= 0; j--) {
        	if (max == 0 && distances[j] != INF) {
        		max = distances[j];
        	}
        	if (max != 0) {
        		if (max == distances[j])
        			answer++;
        		else
        			break;
        	}
        }
        return answer;
    }
    
    static class Pair  implements Comparable<Pair> {
    	int v;
    	int w;
    	
    	Pair(int v, int w) {
    		this.v = v;
    		this.w = w;
    	}
    	
    	public int compareTo(Pair o) {
    		return this.w - o.w;
    	}
    }

}
