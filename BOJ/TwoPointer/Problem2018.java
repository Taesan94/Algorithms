package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2018 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int result = 1;
		
		int s = 1;
		int e = 1;
		int sum = 0;
		int finish = n / 2;
		if (n % 2 != 0)
			finish++;
		
		while (true) {
			if (sum >= n) {
				sum -= s++;
			}else if (e > finish) {
				break ;
			} else {
				sum += e++;
			}
			if (sum == n) {
				result++;
			}
		}
		System.out.println(result);
	}

}
