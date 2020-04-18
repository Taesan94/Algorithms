package Programmers.Level3;

import java.util.Arrays;
import java.util.Stack;

public class WordChange {

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";

		String[] words = {
				"hot","dot","dog","lot","log"
		};

		int result = solution(begin,target,words);

		System.out.println(" result : " + result );

	}//main

	public static int solution(String begin, String target, String[] words) {

		if(!Arrays.asList(words).contains(target)) return 0;

		// 하나만 다른 단어가 있는지 찾아야 된다.
		Stack begins = new Stack<String>();
		begins.add(begin);

		int cnt = 0 ;
		while ( !begins.isEmpty() ) {

			String begin2 = (String)begins.pop();
			
				for ( int i = 0 ; i < words.length; i ++ ) {
					String word = words[i];
					int diff = 0 ;
					for ( int j = 0 ; j < word.length(); j++ ) {
						if( word.charAt(j) != begin2.charAt(j)) diff++;
						if(diff > 1 ) break;
					}

					if(diff==1) {
						if( target.equals(word)) return cnt+1;
						else begins.add(word);
					}
				}
			cnt++;
		}
		return 0;
	}

}//class
