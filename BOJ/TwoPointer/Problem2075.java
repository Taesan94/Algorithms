package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2075 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[(int)Math.pow(n, 2)];
		
		int j = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			while (st.hasMoreTokens()) {
				arr[j++] = Integer.valueOf(st.nextToken());
			}
		}
		
		Arrays.sort(arr);
		System.out.println(arr[arr.length - n]);
	}

}
