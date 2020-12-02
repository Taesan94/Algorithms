package Programmers.BackJoon.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1543 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String find = br.readLine();

		int seq = 0;
		int before = s.length();
		int len = find.length();
		s = s.replace(find, "");
		seq += (before - s.length())/len;
		System.out.println(seq);
	}

}
