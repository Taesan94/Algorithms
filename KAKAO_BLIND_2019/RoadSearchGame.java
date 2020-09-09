package Programmers.KAKAO_BLIND_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadSearchGame {

	public static void main(String[] args) {

		int[][] nodeinfo = {
				{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		};
		int[][] result = solution(nodeinfo);

		System.out.println("##### result #####");
		for(int[] r : result) {
			System.out.println(Arrays.toString(r));
		}
	}

	static Node[] nodes;
	static List<Integer> list; 
	static int[][] answer;
	static int index = 0;

	public static int[][] solution(int[][] nodeinfo) {
		answer = new int[2][nodeinfo.length];

		// nodeinfo를 돌아서, Node 배열을 만들고 , 
		// Node배열을 , y기준 내림차순
		// x기준 오름차순 순서로 정렬 !
		nodes = new Node[nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++) {
			nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
		}

		Arrays.sort(nodes, (o1, o2) -> {
			return o2.y - o1.y == 0 ? o1.x - o2.y : o2.y - o1.y;
		});

		Node root = nodes[0];

		// 2진트리 만들어 주기.
		for (int i = 1; i < nodes.length; i++) {
			makeBinaryTree(root, nodes[i]);			
		}

		preOrder(root);
		index = 0;
		postOrder(root);

		return answer;
	}

	static void makeBinaryTree(Node root, Node insertNode) {
		if (root.x > insertNode.x) {
			if (root.left == null)
				root.left = insertNode;
			else
				makeBinaryTree(root.left, insertNode);
		} else {
			if (root.right == null)
				root.right = insertNode;
			else
				makeBinaryTree(root.right, insertNode);
		}
	}

	static void preOrder(Node node) {

		if (node == null)
			return;

		// root
		answer[0][index++] = node.index;
		// left
		preOrder(node.left);
		// right
		preOrder(node.right);
	}

	static void postOrder(Node node) {

		if (node == null)
			return;

		// left
		postOrder(node.left);
		// right
		postOrder(node.right);
		// root
		answer[1][index++] = node.index;
	}

	static int[] getArr() {
		int[] arr = new int[list.size()];

		int i = 0;
		for (int v : list) {
			arr[i++] = v;
		}
		return arr;
	}

	static class Node {

		int x;
		int y;
		int index;

		Node left = null;
		Node right = null;

		Node (int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}

		public String toString() {
			return "("+x+", "+y+", index : " + index +")";
		}


	}
}
