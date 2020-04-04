package Programmers.Level2;

public class NormalSquare {

	public static void main(String[] args) {
		
		long answer = gcd(17,54);
		long answer2 = gcd(17,54);
		
		System.out.println(" answer1 : " + answer +", answer2 : " + answer2 );

	}//main
	
	
	public static long solution(int w,int h) {
		
		long wl = Long.parseLong(String.valueOf(w));
		long hl = Long.parseLong(String.valueOf(h));
		
		return (wl*hl) - ( wl+hl-gcd(wl,hl));
	}
	
	private static long gcd( long w , long h ) {
		
		long small,big ;

		big = w >= h ? w : h ;
		small = w < h ? w : h ;

		while ( small != 0 ) {
			long nmg = big % small ;
			big = small;
			small = nmg;
		}
		return big;
	}
	
	private static long gcd2( long w, long h ) {
		return w%h == 0 ? h : gcd(h,w%h);
	}

}//class
