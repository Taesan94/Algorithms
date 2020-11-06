package Programmers.Level2_Retry1;

public class Country_124 {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}
	
    public static String solution(int n) {
    	StringBuilder sb = new StringBuilder("");
        while (n != 0) {
        	int num = n % 3;
        	
        	if (num == 0) {
        		num = 4;
        		n -= 1;
        	}
        	sb.append(num);
        	n /= 3;
        }
        sb.reverse();
        return sb.toString();
    }

}
