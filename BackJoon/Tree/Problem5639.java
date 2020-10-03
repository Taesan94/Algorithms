package Programmers.BackJoon.Tree;

import java.util.Scanner;

public class Problem5639 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int root = scan.nextInt();
		Node rootNode = new Node(root);

		while(scan.hasNext()) {
			int v = scan.nextInt();
			rootNode = insertNode(rootNode, v);
		}
		postOrder(rootNode);
	}
	
	static Node insertNode(Node rootNode, int v) {
		
		if (rootNode == null)
			return new Node(v);
		
		if (v < rootNode.root) {
			Node child = insertNode(rootNode.left, v);
			rootNode.left = child;
		} else {
			Node child = insertNode(rootNode.right, v);
			rootNode.right = child;
		}
		
		return rootNode;
	}
	
	static void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.root);
		}
	}
	
	static class Node {
		
		int root;
		Node left;
		Node right;
		
		Node(int root){
			this.root = root;
		}
	}
}