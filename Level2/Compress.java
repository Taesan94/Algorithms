package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compress {

	public static void main(String[] args) {

		String msg = "ABABABABABABABAB";

		int[] result = solution(msg);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String msg) {

		Map<String,Integer> addMsg = new HashMap<String,Integer>();
		List<Integer> result = new ArrayList<Integer>();

		String[] splitMsg = msg.split("");

		int addIndex = 27;

		for ( int i = 0 ; i < splitMsg.length; i++ ) {

			if ( i == splitMsg.length-1 ) {
				System.out.println(" 타야되는데 ");
				result.add((int)msg.charAt(msg.length()-1)-64);
			}
			else {
				System.out.println(" Start i : " + i );
				String word =splitMsg[i] + splitMsg[i+1];

				if ( addMsg.get(word) == null ){
					addMsg.put(word,addIndex++);
					result.add((int)msg.charAt(i)-64);
					
					System.out.println("(1) 현재입력("+i+") : " + splitMsg[i] + " 다음글자 : " + splitMsg[i+1] + " 출력 : " +  ((int)msg.charAt(i)-64) + " 추가 된 index [ " + (addIndex-1) +": " + word +" ]");
				}else {
					// i+2부터 하나씩 붙여가야 됨.
					i+=2;
					
					// 마지막인지 확인, 아니라면 while타지 않음.
					boolean last = true;
					while ( addMsg.get(word) != null ) {
						word += splitMsg[i];
						i++;
						last = false;
						if ( i > msg.length()-1) break;
					}
					
					if ( last || (!last) && addMsg.get(word) != null ) {
						result.add(addMsg.get(word));
						System.out.println("(3) 현재입력("+i+") : " + word + " 다음글자 : " +  " " + " 출력 : " + addMsg.get(word) + " 추가 된 index [ " + (addIndex-1) +" ]");
						break;
					}else {
						addMsg.put(word, addIndex++);
						result.add(addMsg.get(word.substring(0,word.length()-1)));
						System.out.println("(2) 현재입력("+i+") : " + word.substring(0,word.length()-1) + " 다음글자 : " +  word.substring(word.length()-1,word.length()) + " 출력 : " + addMsg.get(word.substring(0,word.length()-1)) + " 추가 된 index [ " + (addIndex-1) +": " +word + " ]" );
					}
					// for에서 ++되도록 i는 다시 -2해줌;
					i--;
					

				}
			}
		}
		System.out.println( "addMsg : " + addMsg.toString());
		System.out.println( "result : " + result.toString());

		int[] answer = new int[result.size()];
		for ( int i = 0; i < result.size(); i++ ) {
			answer[i] = (int)result.get(i);
		}

		return answer;
	}

}
