package Programmers.Level2;

import java.util.Stack;

public class RemovePair {

	public static void main(String[] args) {
		String s= "acca";
		int result = solution2(s);

		System.out.println(" result : " + result );
	}

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

}
