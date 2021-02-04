package Basic.BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordChange {

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";

		String[] words = {
				"hot" , "hop"
		};

		int result = solution(begin, target, words);

		System.out.println( "result : " + result );

	}

	static String[] stWords;

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		stWords = words;

		// target이 없는 경우.
		if( !Arrays.asList(words).contains(target) ) {
			return answer ;
		}

		// 원본데이터
		Queue<String> origin = new LinkedList<>();

		for ( String s : words ) {
			origin.add(s);
		}
		
		Queue<String> pos = new LinkedList<>();
		
		while( !origin.isEmpty() ) {
			
			String compare = origin.poll();

			int diff = 0 ;
			for( int i=0; i<begin.length(); i++ ) {
				if( begin.charAt(i) != compare.charAt(i)) {
					diff++;
				}
			}
			
			if( diff == 1 ) {
				if( compare.equals(target) ) return answer;
				else pos.add(compare);
			}else {
				origin.add(compare);
			}
			
			
			
		}


		return answer;
	}



}//class
