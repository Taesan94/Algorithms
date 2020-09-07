package Programmers.KAKAO_BLIND_2020;

import java.util.Arrays;

public class StringCompress {

	public static void main(String[] args) {

		String s = "aabbaccc";

		System.out.println("result : " + solution(s));

	}

	public static int solution(String s) {
		
		int min = 1000;
		
		// 2 ~ s.length / 2개씩 잘라 본다. 모두 봐야 함.
		for (int i = 1; i <= s.length() / 2; i++) {
			
			int answer = 0;
			 // if ( i > 1 ) break;

			String copy = new String(s);
			// 1. i개로 자른 문자열이 없을때까지 반복.
			String startW = s.substring(0,i);
			
			int cnt = 0;
			
			while (true) {
				
				/**/
				// 잘라도 되는 경우 ?
				if (copy.startsWith(startW)) {
					
					if (copy.length() >= i) {
						copy = copy.substring(i);
						cnt++;
					}
					else
						break;
					
					if (copy.equals("")) {
						answer += plusNum(cnt, i);;
						break;
					}
					continue;
				} else { // 없을 때, startW를 바꾼다.
					if (copy.length() >= (i * 2)) {
						startW = copy.substring(0, i);
						answer += plusNum(cnt, i);
						cnt = 0;
					} else {
						answer += plusNum(cnt, i);
						break;
					}
						
				}
			}
			answer += copy.length();
			min = Math.min(answer, min);
		}
		return Math.min(s.length(), min);
	}
	
	static int plusNum(int cnt, int i) {
		if (cnt != 1) {
			return String.valueOf(cnt).length() + i;
		}
		
		return i;
	}

}
