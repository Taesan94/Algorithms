package BOJ.Strings;

import java.util.Scanner;

public class Problem3033 {

	public static void main(String[] args) {
		
		
		int answer = 0;
		
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.valueOf(scan.nextLine());
		String s= scan.nextLine();
		
		int max = n / 2;
		
		for (int i = 1; i <= max; i++) {
			// i자릿수 만큼 자른다.
			for (int j = 0; j < s.length(); j++) {
				String split = s.substring(j, i);
			}
		}
		
		
		
		System.out.println(answer);
		
	}
}
