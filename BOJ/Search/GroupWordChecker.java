package BOJ.Search;

import java.util.Scanner;

public class GroupWordChecker {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
				
		String[] words = new String[n];
		for( int i = 0 ; i < n ; i ++ ) {
			words[i] = scan.next();
		}
		int result = solution(words);
		System.out.println(result);
	}
	
	private static int solution( String[] words ) {
		int answer = 0 ;
		
		for( String w : words ) {
			
			boolean possible = true;
			
			if(w.length() == 1 ) answer++;
			else {
				
				boolean[] visit = new boolean[26];
				
				for(int i = 0 ; i < w.length()-1; i ++ ) {
					// 다르면 앞의 문자를 방문한다.
					if( w.charAt(i) != w.charAt(i+1)) {
						if( visit[w.charAt(i)-97] ) {
							possible=false;
							break;
						}else visit[w.charAt(i)-97] = true;
					}
				}
				// 마지막글자가 방문했던글자면 false, 아니면 true이다.
				if(possible) possible = !visit[w.charAt(w.length()-1)-97];
				if(possible) answer++;
			}
			
		}
		return answer ;
	}

}
