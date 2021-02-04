package BOJ.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10798 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		String s4 = br.readLine();
		String s5 = br.readLine();
		
		int max = Math.max(s1.length(), Math.max(s2.length(), Math.max(s3.length(), Math.max(s4.length(), s5.length()))));
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < max; i++) {
			if (checkLen(s1, i)) sb.append(s1.charAt(i));
			if (checkLen(s2, i)) sb.append(s2.charAt(i));
			if (checkLen(s3, i)) sb.append(s3.charAt(i));
			if (checkLen(s4, i)) sb.append(s4.charAt(i));
			if (checkLen(s5, i)) sb.append(s5.charAt(i));
		}
		System.out.println(sb.toString());
	}
	
	private static boolean checkLen(String s, int i) {
		if (i <= s.length() - 1 && s.charAt(i) != ' ')
			return true;
		return false;
	}
}

