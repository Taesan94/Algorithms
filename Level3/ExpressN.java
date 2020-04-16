package Programmers.Level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExpressN {

	static Map<Integer,Set<Integer>> m = new HashMap<>();

	public static void main(String[] args) {

		int n =5 ;
		int number = 12 ;

		int result = solution(n,number);
		System.out.println(" result : " + result );

	}

	public static int solution(int N, int number) {

		if( N == number ) return 1;

		Set<Integer> prev = new HashSet<Integer>();
		prev.add(N);
		prev.add(-N);
		m.put(1,prev);

		int seq = 2 ;

		int fullN = N;

		while( seq < 8 ) {

			boolean result = false;

			for ( int i = 1 ; i <= seq/2; i++ ) {
				int next = seq-i;
				// a 하고 b를 가지고 사칙연산 조지기.
				result = makeBundle(m.get(i),m.get(next),N,number,seq, fullN);
				if(result) return seq;
			}
			seq++;
			fullN = fullN*10+N;
		}

		return -1;
	}


	private static boolean makeBundle(Set<Integer> one,Set<Integer> two, int N, int number, int seq, int fullN) {

		Iterator itr = two.iterator();

		Set<Integer> curr = new HashSet<Integer>();

		while(itr.hasNext()) {
			int num = (int)itr.next();
			Iterator itr2 = one.iterator();
			while(itr2.hasNext()) {
				int num2 = (int)itr2.next();

				int plus = num+num2;
				int minus = num-num2;
				int multiple = num*num2;
				
				int division = plus;
				if( num2 != 0 ) division = num/num2;

				if(plus == number || minus == number || multiple == number || division == number ) return true;
				
				curr.add(plus);
				curr.add(minus);
				curr.add(multiple);
				curr.add(division);
			}
		}

		fullN = fullN*10+N;

		if( fullN == number ) return true;
		else curr.add(fullN);

		m.put(seq, curr);

		return false;

	}

}
