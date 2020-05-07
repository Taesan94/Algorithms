package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MostDistantNode {

	public static void main(String[] args) {
		int n = 6;

		int[][] vertex = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};

		int result = solution(n,vertex);

		System.out.println( "result : " + result );

	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int N = n+1;
        
        // 주어진 정점들을 연결한다.
        // 1번 노드부터 순회한다.
        // 해당 노드까지의 최소거리를 구한다.
        // 최소거리는 현재노드까지의 거리 + 다음노드까지의 거리로 구한다.
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for( int i=0; i<N; i++) graph.add(new ArrayList<>());
        
        for( int[] v : edge ) {
        	graph.get(v[0]).add(v[1]);
        	graph.get(v[1]).add(v[0]);
        }
        
        System.out.println(" ### Graph : " + graph.toString());
        
        boolean[] visit = new boolean[N];
        int[] distance = new int[N];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visit[1]=true;
        
        while(!q.isEmpty()) {
        	
        	int vertex = q.poll();
        	List<Integer> connect = graph.get(vertex);
        	
        	for( int i=0; i<connect.size(); i++) {
        		int v = connect.get(i);
        		if( !visit[v] ) {
        			q.add(v);
        			visit[v] = true;
        			distance[v] = distance[vertex]+1;
        		}
        	}
        }

        Arrays.sort(distance);
        int max = distance[n];
        
        for( int i=n; i>=0; i--) {
        	if(max==distance[i]) answer++;
        	else break;
        }
        
        System.out.println(Arrays.toString(distance));
        return answer;
    }

}
