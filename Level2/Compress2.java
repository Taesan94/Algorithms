package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Compress2 {

	public static void main(String[] args) {

		String msg = "TOBEORNOTTOBEORTOBEORNOT";

		int[] result = solution(msg);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String msg) {

		String[] msgArr = msg.split("");

		Map<String,Integer> addMsg = new LinkedHashMap<String,Integer>();
		List<Integer> result = new ArrayList<Integer>();

		int addIndex = 27;

		for ( int i = 0 ; i < msgArr.length; i++ ) {

			if ( i == msgArr.length-1 ) result.add(msg.charAt(i)-64);

			else {
				String word = msgArr[i]+msgArr[i+1];

				// 문자열 길이가 3이상인 대상은 해당조건에 탈 수 없다.
				if ( addMsg.get(word)==null ) {
					result.add(msg.charAt(i)-64);
					addMsg.put(word,addIndex++);
				}else {

					i+=2;

					String w = "";
					String c = "";

					while( i < msgArr.length && addMsg.get(word) != null ) {
						w = word;
						c = msgArr[i++];
						word  = w+c;
					}

					// loop에서 +1되서넘어오고, for문에의해 +1됨으로 -2해줌.
					i-=2;

					if( i == msgArr.length-2 && addMsg.get(word) != null){
						result.add(addMsg.get(word));
						break;
					}else{
						result.add(addMsg.get(w));
						addMsg.put(word, addIndex++);
					}
				}
			}
		}

		int[] answer = new int[result.size()];

		for ( int i = 0 ; i < result.size(); i ++ ) {
			answer[i] = result.get(i);
		}

		return answer;
	}

}
