package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5052 {

	public static void main2(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {

			int n = Integer.valueOf(br.readLine());

			String[] numbers = new String[n];
			for (int j = 0; j < n; j++) {
				numbers[j] = br.readLine();
			}

			if(isPossible(numbers)) {
				System.out.println("YES");
			}else
				System.out.println("NO");

		}
	}

	static boolean isPossible(String[] numbers) {
		boolean answer = true;

		Arrays.sort(numbers);
		
		for (int i = 1; i < numbers.length; i++) {

			String n1 = numbers[i];

			for (int j = i - 1; j >= 0; j--) {
				String n2 = numbers[j];
				
				if (n1.startsWith(n2)) {
					return false;
				}
			}
		}
		return answer;
	}




	public static void main3(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {

			boolean possible = true;
			Trie[] tries = new Trie[11];
			int n = Integer.valueOf(br.readLine());

			String[] numbers = new String[n];

			for (int j = 0; j < n; j++) {
				String number = br.readLine();
				numbers[j] = number;
				if (tries[number.length()] == null)
					tries[number.length()] = new Trie();
				tries[number.length()].insert(number);
				// System.out.println("tries[" + number.length() +"] : " + tries[number.length()].toString());
			}

			for (int k = 0; k < n; k++) {
				String number = numbers[k];

				int cnt = 0;
				for (int r = number.length(); r < 11; r++) {

					Trie trie = tries[r];

					if (trie == null)
						continue;

					// System.out.println(" r : " + r + " trie.tostring : " + trie.toString());
					// System.out.println("trie.contains("+number+") : " + trie.contains(number));

					cnt += trie.contains(number);
				}

				if (cnt >= 2) {
					possible = false;
					break;
				}
			}

			if (possible)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {
			

			Trie2 root = new Trie2();
			boolean possible = true;
			int n = Integer.valueOf(br.readLine());

			String[] numbers = new String[n];

			for (int j = 0; j < n; j++) {
				String number = br.readLine();
				numbers[j] = number;
			}
			
			Arrays.sort(numbers);
			
			for (int k = 0; k < n; k++) {
				String number = numbers[k];
				
				if (!insert(root, number)) {
					possible = false;
					break;
				}
				
			}
			
			if(!possible)
				System.out.println("NO");
			else
				System.out.println("YES");

		}
	}
	
	static boolean insert(Trie2 root, String number) {
		
		Trie2 curr = root;
		
		boolean exist = true;
		
		for (char c : number.toCharArray()) {
			if (curr.childs[c - '0'] == null) {
				exist = false;
				curr.childs[c - '0'] = new Trie2();
			}
			
			if (curr.isLast) {
				exist = true;
				break;
			}
			
			curr = curr.childs[c - '0'];
		}
		
		if (exist) {
			return false;
		}
		
		curr.isLast = true;
		
		return true;
	}
	
	static class Trie2 {
		
		Trie2[] childs;
		boolean isLast;
		
		Trie2() {
			childs = new Trie2[10];
			isLast = false;
		}
		
		public String toString() {
			return Arrays.toString(childs) + "is Last .. : " + isLast + "\n";
		}
	}
	

	static class Trie {

		private Node root;

		Trie() {
			root = new Node();
		}

		void insert(String number) {

			Node wk = root;

			for(char c : number.toCharArray()) {
				wk.cnt++;
				wk = wk.getChildNodes().computeIfAbsent(c, value -> new Node());
			}

			wk.setLastChar(true);
		}

		int contains(String number) {

			Node wk = root;

			for(char c : number.toCharArray()) {
				Node child = wk.getChildNodes().get(c);
				if (child == null) {
					return 0;
				}
				wk = child;
			}
			return 1;
		}

		public String toString() {
			return root.toString();
		}
	}

	static class Node {
		private Map<Character, Node> childNodes = new HashMap<>();
		private boolean isLastChar;
		private int cnt = 0;

		public Map<Character, Node> getChildNodes() {
			return childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public String toString() {
			return childNodes.toString() + ", cnt : " + cnt;
		}
	}
}
