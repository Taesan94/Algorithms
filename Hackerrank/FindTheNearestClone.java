package Hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindTheNearestClone {

	public static void main(String[] args) {
		int graphNodes = 4;

		int[] graphFrom = {
				1,1,4
		};

		int[] graphTo = {
				2,3,2
		};

		long[] ids = {
				2,1,1,2
		};

		int val = 2;
		System.out.println("result :" + findShortest(graphNodes, graphFrom, graphTo, ids, val));

		File file = new File("C:\\KTS_DEV\\newWorkSpace\\algorithmData\\src\\Programmers\\Hackerrank\\FindTheNearsetClone_Test");

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Long> ids2_temp = new ArrayList<>();
		int val2 = 0;
		
		Set<Integer> nodeCnt = new HashSet<>();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] lines = line.split(" ");
				if (lines.length > 2) {
					for (String s : lines) ids2_temp.add(Long.valueOf(s));
				} else if (lines.length == 1) {
					val2 = Integer.valueOf(lines[0]);
				} else {
					int from = Integer.valueOf(lines[0]);
					int to = Integer.valueOf(lines[1]);
					list1.add(from);
					list2.add(to);
					nodeCnt.add(from);
					nodeCnt.add(to);
				}
				System.out.println(line);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		int[] from2 = new int[list1.size()];
		int[] to2 = new int[list2.size()];
		long[] ids2 = new long[ids2_temp.size()];
		
		setIntArr(from2, list1);
		setIntArr(to2, list2);
		setLongArr(ids2, ids2_temp);
		
		
		System.out.println("result2 :" + findShortest(nodeCnt.size(), from2, to2, ids2, val2));
		
	}
	
	static void setIntArr(int[] arr, List<Integer> list) {
		int i = 0;
		for (int num : list) {
			arr[i++] = num;
		}
	}
	static void setLongArr(long[] arr, List<Long> list) {
		int i = 0;
		for (long num : list) {
			arr[i++] = num;
		}
	}

	static int INF = 1000002;
	static int min = INF;
	static Map<Long,List<Integer>> map = new HashMap<>();
	static List<Integer>[] graph;
	static PriorityQueue<Node> valInfo = new PriorityQueue<>();
	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

		System.out.printf("graphNodes : %d, from len : %d, to len : %d, ids len : %d , val : %d \n",graphNodes, graphFrom.length, graphTo.length, ids.length, val);
		
		
		graph = new List[graphNodes + 1];
		for (int i = 0; i <= graphNodes; i++) {
			graph[i] = new ArrayList<>();
		}

		if (ids[0] == val)
			valInfo.add(new Node(0, 1, 0));
		
		for (int i = 1; i < ids.length; i++) {
			
			long color = ids[i];
			
			List<Integer> list = map.getOrDefault(color, new ArrayList<>());
			list.add(graphTo[i - 1]);
			

			int from = graphFrom[i];
			int to = graphTo[i];
			graph[from].add(to);
			graph[to].add(from);
			
			if (i + 1 <= ids.length - 1 && (val == ids[i + 1])) {
				valInfo.add(new Node(from, to, 0));
			}
			
		}
		
		for (int i = 0; i < graphFrom.length; i++) {

			int from = graphFrom[i];
			int to = graphTo[i];
			graph[from].add(to);
			graph[to].add(from);

			if (i + 1 <= ids.length - 1 && (val == ids[i + 1])) {
				valInfo.add(new Node(from, to, 0));
			}
		}
		
		
		
		boolean[] visited = new boolean[graphNodes + 1];

		while (!valInfo.isEmpty()) {
			Node node = valInfo.poll();

			if (!visited[node.to]) {
				Queue<Node> q= new LinkedList<>();
				q.add(node);

				while (!q.isEmpty()) {
					Node n = q.poll();

					if (visited[n.to])
						continue;
					visited[n.to] = true;

					if (n.depth != 0 && ids[n.to - 1] == val) {
						min = Math.min(min, n.depth);
						break ;
					}
					List<Integer> list = graph[n.to];
					for (int i = 0; i < list.size(); i++) {
						int nextV = list.get(i);
						if (!visited[nextV]) {
							q.add(new Node(n.to, nextV, n.depth + 1));
						}
					}
				}
			}
		}

		if (min == INF)
			return -1;

		return min;
	}

	static class Node implements Comparable<Node> {

		int from;
		int to;
		int depth;

		public Node(int from, int to, int depth) {
			this.from = from;
			this.to = to;
			this.depth = depth;
		}

		@Override
		public int compareTo(Node o) {
			int result = this.from - o.from;

			if (result == 0)
				return this.to - o.to;
			return result;
		}

		public String toString() {
			return "from : " + from +", to : " + to +", depth : " + depth +"\n";
		}
	}

}
