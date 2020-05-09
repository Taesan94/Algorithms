package Programmers.AlgorithmBasic.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Trie_Ref {

	public static void main(String[] args) {
		String[] words = {
				"frodo", "front", "frost", "frozen", "frame", "kakao"
		};

		String[] queries = {
				"fro??", "????o", "fr???", "fro???", "pro?"
		};
		
		int[] result = solution(words,queries);

		System.out.println(Arrays.toString(result));

	}

	public static int[] solution(String[] words, String[] queries) {
		Trie[] tries = new Trie[100001];
		for (String word : words) {  
			int len = word.length();
			if (tries[len] == null) tries[len] = new Trie();
			tries[len].insert(word);
		}
		
		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int len = queries[i].length();
			if (tries[len] == null) answer[i] = 0;
			else {
				System.out.println( queries[i]);
				System.out.println("tries["+len+"] : " + tries[len].toString() );
				answer[i] = tries[len].getCount(queries[i]);
			}
		}
		return answer;
	}
	
	static class Trie {
		Node front;
		Node back;

		Trie() {
			this.front = new Node();
			this.back = new Node();
		}

		public void insert(String word) {
			insertFront(word);
			insertBack(word);
		}

		private void insertFront(String word) {
			Node node = front;
			for (int i = 0; i < word.length(); i++) {
				node.count++;
				node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
			}
		}

		private void insertBack(String word) {
			Node node = back;
			for (int i = word.length() - 1; i >= 0; i--) {
				node.count++;
				node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
			}
		}

		public int getCount(String query) {
			if (query.charAt(0) == '?') return getCountFromBack(query);
			else return getCountFromFront(query);
		}

		private int getCountFromFront(String query) {
			Node node = front;
			for (int i = 0; i < query.length(); i++) {
				if (query.charAt(i) == '?') break;
				if (!node.children.containsKey(query.charAt(i))) return 0;
				node = node.children.get(query.charAt(i));
			}
			return node.count;
		}

		private int getCountFromBack(String query) {
			Node node = back;
			for (int i = query.length() - 1; i >= 0; i--) {
				if (query.charAt(i) == '?') break;
				if (!node.children.containsKey(query.charAt(i))) return 0;
				node = node.children.get(query.charAt(i));
			}
			return node.count;
		}
		@Override
		public String toString() {
			return "Trie [front=" + front + ", back=" + back + "]";
		}
	}

	static class Node {
		Map<Character, Node> children;
		int count;

		Node(){
			this.children = new HashMap<>();
			this.count = 0;
		}

		@Override
		public String toString() {
			return "Node [children=" + children.toString() + ", count=" + count + "]";
		}
	}
}


