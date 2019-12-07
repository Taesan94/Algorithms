package Programmers.Level2;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

	public static void main(String[] args) {

		String[][] clothes ={
				{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
		};

		int answer = solution(clothes);

		System.out.println(answer);

	}//main

	public static int solution(String[][] clothes) {
			
		// 경우의 수를 찾아서, 산식에 대입해준다.
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		for ( String[] clothe : clothes ) {
			m.put( clothe[1], (m.getOrDefault(clothe[1], 0)+1) );
		}
		
		int answer = 1;
		
		for ( int num : m.values() ) {
			answer*=(num+1);
		}
		
		answer--;
		
		return answer ;
	}
}//class
