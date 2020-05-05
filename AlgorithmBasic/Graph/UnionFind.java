package Programmers.AlgorithmBasic.Graph;

/*
 여러개의 노드가 존재할 때 두 개의 노드를 선택해서,
 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘이다.
 */
public class UnionFind {

	public static void main(String[] args) {
		
		// 해당 노드의 부모 노드를 기록한다.
		// 부모가 되는 대상은 더 작은 값을 부모로 생각한다.
		int[] parent = new int[11];
		
		// 초기 값은 자기자신을 부모로 가지도록 셋팅해준다.
		for(int i=1; i<parent.length; i++) {
			parent[i]=i;
		}
		
		union(parent,1,2);
		union(parent,2,3);
		union(parent,3,4);
		union(parent,5,6);
		union(parent,6,7);
		union(parent,7,8);
		
		System.out.println("1과 5는 연결이 되어있나요 ? " + findParent(parent,1,5) );
		union(parent,1,5);
		System.out.println("1과 5는 연결이 되어있나요 ? " + findParent(parent,1,5) );
		
	}
	
	// 해당 노드의 부모노드의 값을 반환해준다.
	private static int getParent(int[] parent, int node) {
		// 자기자신이 부모라면 그대로 return해준다.
		if( parent[node] == node ) return node; 
		else // 그렇지 않다면 해당 노드의 부모노드를 재귀해서 연결 된 최종 노드를 찾는다.
			return getParent(parent,parent[node]);
	}
	
	// 두 개의 노드를 입력받아서,
	// 최상위 부모를 찾고 연결시켜준다.
	private static void union(int[] parent, int a, int b ) {
		// 입력받은 노드의 최상위 부모노드를 찾는다.
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		// 더 작은 값이 부모가 되도록 연결시켜준다.
		if( a<b ) parent[b] = a;
		else parent[a] = b;
	}
	
	// 두 노드가 연결되어있는지 확인한다.
	static boolean findParent(int parent[], int a, int b ) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		return ( a==b );
	}
}
