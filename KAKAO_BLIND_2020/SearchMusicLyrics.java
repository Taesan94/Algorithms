package Programmers.KAKAO_BLIND_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchMusicLyrics {

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
		int[] answer = new int[queries.length];
		
		// 문자열 크기 별로 검색 Trie를 따로만들어준다.
		Trie[] tries = new Trie[10001];
		
		for ( String word : words ) {
			if( tries[word.length()] == null ) 
				tries[word.length()] = new Trie();
			
			tries[word.length()].insert(word);
		}
		
		
		int index = 0 ;
		
		for (String query : queries) {
			int cnt = 0;
			Trie trie =  tries[query.length()];
			if (trie == null)
				cnt = 0;
			else  
				cnt = tries[query.length()].contains(query);
			answer[index++] = cnt;
		}
		return answer;
	}


	static class Trie{

		private TrieNode root ;
		private TrieNode reverse ;

		Trie() { 
			root = new TrieNode(); 
			reverse = new TrieNode();
		}
		
		// 1. words들을 모두 등록해준다.
		// 2. ???가 앞에있는 경우 편하게 하기위해 문자열을 뒤집은 경우도 하나 기록해준다.
		void insert(String word) {
			insertFront(word);
			insertReverse(word);
		}

		void insertFront(String word) {

			TrieNode thisNode = root;

			for( int i=0; i<word.length(); i++ ) {
				thisNode.cnt++;
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), value -> new TrieNode());
			}
			thisNode.setLastChar(true);
		}
		
		void insertReverse(String word) {
			
			TrieNode thisNode = reverse;
			word = new StringBuilder(word).reverse().toString();

			for( int i=0; i<word.length(); i++ ) {
				thisNode.cnt++;
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), value -> new TrieNode());
			}
			
			thisNode.setLastChar(true);
		}

		// 특정 단어가 들어가 있는지 확인.
		int contains(String query) {
			
			TrieNode thisNode;
			
			if(query.charAt(0) =='?') {// ???문자열 인경우 -> 문자열 ???로 바꿔준다.
				query = new StringBuilder(query).reverse().toString();
				thisNode = reverse;
			}else {
				thisNode = root;
			}
			
			for( int i=0; i < query.length(); i++ ) {
				char c = query.charAt(i);
				
				if(c == '?') 
					break;
				
				TrieNode node = thisNode.getChildNodes().get(c);
				
				if(node == null)
					return 0;
				
				thisNode = node ;
			}
			
			return thisNode.cnt;
		}
	}



	public static class TrieNode{

		// 자식 노드를 가지고 있는 map 정보.
		private Map<Character, TrieNode> childNodes = new HashMap<>();

		// 마지막 글자인지를 확인한다.
		private boolean isLastChar;
		
		private int cnt = 0 ;

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		@Override
		public String toString() {
			return "TrieNode [childNodes=" + childNodes + ", isLastChar=" + isLastChar + "]";
		}

	}






}
