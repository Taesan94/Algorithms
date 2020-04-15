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
		Stack s = new Stack<String>();
		s.add(begin);

		int cnt = 0 ;
		while ( !s.isEmpty() ) {

			String[] words2 = new String[s.size()];

			int index = 0 ;

			while ( !s.isEmpty()) {
				words2[index++] = (String)s.pop();
			}


			for ( int k = 0 ; k < words2.length; k++ ) {
				
				String begin2 = words2[k];
				
				for ( int i = 0 ; i < words.length; i ++ ) {
					String word = words[i];
					int diff = 0 ;
					for ( int j = 0 ; j < words[i].length(); j++ ) {
						if( word.charAt(j) != begin2.charAt(j)) diff++;
						if(diff > 1 ) break;
					}

					if(diff==1) {
						if( target.equals(word)) return cnt+1;
						else s.add(word);
					}
				}
			}
			cnt++;
		}
		return 0;
	}

}//class
