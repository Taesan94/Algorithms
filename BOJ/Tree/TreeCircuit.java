package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TreeCircuit {
	
	static Map<String,Tree> tree = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.put(st.nextToken(), new Tree(st.nextToken(), st.nextToken()));
		}
		
		preOrder("A", tree.get("A"));
		System.out.println();
		midOrder("A", tree.get("A"));
		System.out.println();
		postOrder("A", tree.get("A"));
	}
	
	static void preOrder(String node, Tree child) {
		System.out.print(node);
		
		if (!child.left.equals(".")) {
			preOrder(child.left, tree.get(child.left));
		}
		
		if (!child.right.equals(".")) {
			preOrder(child.right, tree.get(child.right));
		}
	}
	
	static void midOrder(String node, Tree child) {
		if (!child.left.equals(".")) {
			midOrder(child.left, tree.get(child.left));
		}
		
		System.out.print(node);
		
		if (!child.right.equals(".")) {
			midOrder(child.right, tree.get(child.right));
		}
	}
	
	static void postOrder(String node, Tree child) {
		if (!child.left.equals(".")) {
			postOrder(child.left, tree.get(child.left));
		}
		if (!child.right.equals(".")) {
			postOrder(child.right, tree.get(child.right));
		}
		System.out.print(node);
	}
	
	static class Tree {
		
		String left;
		String right;

		Tree(String left, String right){
			this.left = left;
			this.right = right;
		}
	}

}
