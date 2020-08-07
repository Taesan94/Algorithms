package Programmers.BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] result = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(st.nextToken());
			result[i] = num;
		}
		
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
		
		int answer =  0;
		int remain = 0;
		for (int i = 0; i < n; i++) {
			answer += remain + result[i];
			remain += result[i];
		}
		System.out.println(answer);
	}
}
