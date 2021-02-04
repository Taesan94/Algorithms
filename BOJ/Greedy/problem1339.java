package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem1339 {
	
	private static long pow(int n) {
		long result = 1;
		for (int i = 0; i < n; i++) {
			result *= 10;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] nums = new long[100];
		int n = Integer.valueOf(br.readLine());
		for (int i = 0; i < n; i++) {
			
			String s = br.readLine();
			int ten = s.length() - 1;
			for (int j = 0; j < s.length(); j++) {
				nums[s.charAt(j)] += pow(ten--);
			}
		}
		
		List<Long> list = new ArrayList<>();
		for (int i = 65; i <= 90; i++) {
			if (nums[i] != 0) {
				list.add(Long.valueOf(nums[i]));
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		int num = 9;
		long result = 0;
		for (int i = 0; i < list.size(); i++) {
			long a = list.get(i) * num--;
			result += a;
		}
		System.out.println(result);
		
	}
}
