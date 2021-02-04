package Basic.AlgorithmBasic.Graph;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private static TrieNode root = new TrieNode();

	public static void main(String[] args) {

		insert("A");
		insert("AB");
		insert("ABC");
		
		System.out.println(" A : " + contains("A"));
		System.out.println(" AB : " + contains("AB"));
		System.out.println(" ABC : " + contains("ABC"));
		System.out.println(" BC : " + contains("BC"));
		System.out.println(" ABCD : " + contains("ABCD"));
		
		System.out.println(root.toString());
		//delete("ABCD");
		System.out.println(root.toString());		
		
		
	}

	static void insert(String word) {

		TrieNode thisNode = root;

		for( int i=0; i<word.length(); i++ ) {
			// getOrDefault와 동일한 기능을한다. 람다 표현식을 이용. , word.charAt(i)를 key로 갖는 TrieNode객체를 생성한다.
			// 즉, 자식노드에서 해당 문자가 Map에 존재하면, 해당 문자의 자식노드를 가져오고,
			// 없다면 해당 문자를 Map의 key값으로 put해준다음에, 빈 TrieNode객체를 가져오게 된다.
			
			// thisNode가 초기홛되기때문에 해당하는 문자열을 계속해서 찾아서 들어가게 된다.
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), value -> new TrieNode());
		}

		// 처음엔 이부분을 이해하지 못했다.
		
		// thisNode는 계속해서 초기화 되기때문에, 입력받은 문자의 마지막 단어가 가지고 있는 자식노드의 child가 된다.
		// 해당 자식노드의 child는 비어있는 map이되겠고, 해당 TrieNode는 마지막임을 true로 해주면 된다 !!!!!!
		thisNode.setLastChar(true);

	}


	// 특정 단어가 들어가 있는지 확인.
	static boolean contains(String word) {

		TrieNode thisNode = root;

		for( int i=0; i < word.length(); i++ ) {
			char c = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(c);

			if( node == null ) return false;

			// 이걸 해주어야, 해당 노드가 가지고 있는 getChildNodes()를 재귀적으로 호출 할 수 있다.
			thisNode = node ;
		}

		// 역시나 thisNode는 자식노드로 계속해서 내려가면서 확인하고 있다.
		// 입력받은 문자열의 마지막 문자가 , 마지막이 맞는지? 를 return 해준다.
		// false라면 해당문자열은 존재하지 않는다는 뜻이다.
		return thisNode.isLastChar();
	}

	// 각 노드는 부모정보는 가지고있지않다.
	// 그렇기 때문에 하위 노드로 내려가면서 삭제 대상을 찾고
	// 다시 올라오면서 삭제하는 콜백(callback)형식으로 구현되어야 한다.
	private static void delete(TrieNode thisNode, String word, int index) {

		char c = word.charAt(index);
		
		// 해당 단어가 존재하지않는경우에는 에러 출력
		if (!thisNode.getChildNodes().containsKey(c)) 
			throw new Error("해당 문자를 찾을 수 없습니다. : [" + word + "]");
		
		TrieNode childNode = thisNode.getChildNodes().get(c);
		index++;
		
		if(index==word.length()) {
			if (!childNode.isLastChar()) 
				throw new Error("해당 단어는 존재하는 단어가 아닙니다. : [" + word + "] ");
			
			childNode.setLastChar(false);
			if (childNode.getChildNodes().isEmpty()) // 마지막 문자를 지운다.
				thisNode.getChildNodes().remove(c);
			
		}else {
			delete( childNode,word,index ); // 콜백함수부분.
			// 자식 노드 정보가 비어있고, 마지막글자가 아니라면 해당 문자열을 삭제해준다.
			if( !childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
				thisNode.getChildNodes().remove(c);
			}
		}
	}
	
	static void delete(String word) {
		delete(root,word,0); // 최초로 delete를 수행한다.
	}
	
	// root가비어있는지 ??
	static boolean isRootEmpty() {
		return root.getChildNodes().isEmpty();
	}

	public static class TrieNode{

		// 자식 노드를 가지고 있는 map 정보.
		private Map<Character, TrieNode> childNodes = new HashMap<>();

		// 마지막 글자인지를 확인한다.
		private boolean isLastChar;

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
