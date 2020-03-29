package Programmers.Level2;

import java.util.Stack;

public class RemovePair {

	public static void main(String[] args) {
		String s= "acca";
		int result = solution2(s);

		System.out.println(" result : " + result );
	}
	
	// 시간초과 때문에 실패.. ! 
	public static int solution(String s)
	{

		String beforeS = s;

		if( beforeS.length() < 2 ) return 0;

		String afterS = makeString(beforeS);

		while( afterS.length() >= 2 && !beforeS.equals(afterS) ) {
			beforeS = afterS ;
			afterS = makeString(beforeS);
		}

		if ( afterS.equals("")) return 1;
		else return 0;

	}
	
	// for solution
	private static String makeString(String beforeS) {
		StringBuilder afterS = new StringBuilder();

		System.out.println(" beforeS : " + beforeS);

		String[] arrayS = beforeS.split("");

		for ( int i = 0; i < arrayS.length-1; i++ ) {

			if ( arrayS[i].equals(arrayS[i+1]) ) {
				i++;
			}else {
				afterS.append(arrayS[i]);
			}

			// 마지막 비교가 끝났을때는, 마지막글자를 무조건 붙여준다.
			if ( i == arrayS.length-2 ) {
				afterS.append(arrayS[i+1]);
			}	
		}
		System.out.println(" afterS : " + afterS );
		return afterS.toString();
	}
	
	// 최초정답 코드..
	public static int solution2(String s)
	{

		if( s.length() < 2 || s.equals("") || s == null ) return 0;

		Stack<Character> stack = new Stack<Character>();

		for ( int i = 0 ; i < s.length()-1; i++ ) {

			while( !stack.isEmpty() && i < s.length() && s.charAt(i)==stack.peek() ) {
				stack.pop();
				i++;
			}
			
			if ( i > s.length() -2  ) {
				if ( i == s.length()-1 ) return 0;
				break;
			}

				if( s.charAt(i) != s.charAt(i+1) ) {
					stack.push(s.charAt(i));
				}else {
					i++;
				}
				
			// 마지막 비교후에 stack에 남아있는 대상이 지워지면 1return
			if ( i == s.length()-2 ){
				if( stack.size()==1 && stack.peek() == s.charAt(i+1) ) {
					return 1;
				}
				return 0;
			}
		}

		if ( stack.isEmpty() ) return 1;

		return 0;
	}
	
	// 풀이보고 다시 풀어보기..
	private static int solution3(String s) {
		// stack에 push한다.
		Stack<Character> stack = new Stack<Character>();
		
		for ( char c : s.toCharArray() ) {
		
			// stack이 비어있다면, 그냥 넣는다.
			if( stack.size() == 0 ) {
				stack.push(c);
				// 이후부터는 앞에 글자가 동일한지 확인한다.
			}else if( stack.peek() == c ) { // 동일하면 pop	
				stack.pop();
			}else {// 동일하지 않다면 push 하면 된다.
				stack.push(c);
			}
		}
		
		return stack.size() == 0 ? 1 : 0;
	}


}
