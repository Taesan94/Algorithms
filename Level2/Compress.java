package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Compress {

	public static void main(String[] args) {

		String msg = "ABABABABABABABAB";

		int[] result = solution(msg);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String msg) {

		Map<String,Integer> dictonary = new TreeMap<String,Integer>();
		List<Integer> result = new ArrayList<Integer>();

		int seq = 27;
		
		String[] msgArr = msg.split("");
		for( int i = 0; i < msg.length(); i++ ) {
			if(i == msg.length()-1) result.add(msg.charAt(i)-'A'+1);
			else {
				String addWord = msgArr[i]+msgArr[i+1];
				
				i = i+2;
				
				while( i < msg.length() && dictonary.get(addWord) != null ) {
					addWord += msgArr[i];
					i++;
				}
				
				if( dictonary.get(addWord) == null ) {
					dictonary.put(addWord, seq++);
					
					String w = addWord.substring(0,addWord.length()-1);
					
					if( dictonary.get(w) != null ) result.add(dictonary.get(w));
					else result.add(w.charAt(0)-'A'+1);

					i = i-2;
				}else {
					result.add(dictonary.get(addWord));
				}
			}
		}
		
		int[] answer = new int[result.size()];
		for ( int i = 0 ; i < result.size(); i++ ) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}

}
