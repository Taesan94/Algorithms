package Programmers.Level2;

import java.util.Stack;

public class Ngame {
	
	static char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};   

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		String result = solution2(n,t,m,p);
		System.out.println(" result : " + result );

	}

	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		// t*m길이 까지 문자열을 구하면 된다.
		int max = t*m;
		String w = "";
		int index = 0;

		while( w.length() < max ) {
			w+=make(n,index);
			index++;
		}
		// 더 숫자가 많은경우는 max까지 잘라준다.
		w = w.substring(0,max);

		System.out.println( " w : " + w );		
		// 이제 p번째에 해당하는 숫자를 t개 뽑아주면 된다.
		for ( int i = p-1; i <w.length(); i+=m ) {
			answer+=w.charAt(i);
		}

		return answer;
	}

	private static String make(int n, int num) {
		String answer = "";

		if(num <= 1) return String.valueOf(num);

		while( true ) {
			String w = "";
			int nmg = num%n;
			if(nmg >= 10) {
				char c = (char)(55+nmg);
				w = String.valueOf(c);
			}else 
				w = String.valueOf(nmg);

			answer = w+answer;
			num/=n;
			if ( num == 0 ) break;
		}
		return answer;
	}
	
	  public static String solution2(int n, int t, int m, int p) {
	      String answer = "";
	      char[] sequence = new char[t * m];
	      Stack<Character> stack = new Stack<>();
	      int count = 0;
	        int number = 0, temp = number;
	        int limit = m * t;

	        System.out.println( "### n : " + n + ", t : " + t + ", m : "+ m +", p : " + p +" ### ");
	        
	        // number > 0부터 진법변환될 정수
	        while(count < limit) {
	        	if(temp < n) {
	                sequence[count++] = numeralSystem[temp];
	                while(!stack.isEmpty() && count < limit) {
	                    sequence[count++] = stack.pop();
	                }
	                System.out.println(" temp < n !! temp : "+ temp + ", number : " + number + ", n : " + n +", count : " + (count-1) );
	                temp = ++number;
	            }else {
	                stack.push(numeralSystem[temp % n]);
	                temp /= n;
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        for(int i = p - 1; i < sequence.length; i+=m) {
	            sb.append(sequence[i]);
	        }
	      return answer = sb.toString();
	  }

}
