package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2467 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
		}
		
		int n1 = 0;
		int n2 = 0;
		
		// 음수 값이 존재한다는 것이 point 
		// diff를 찾는다.
		int left = 0;
		int right = n - 1;
		int diff = 0;
		int min = 2000000000;
		
		while (left < right) {
			
			diff = nums[left] + nums[right];
			
			if (diff == 0) {
				System.out.println(nums[left] +" " + nums[right]);
				return ;
			}
			
			if (Math.abs(diff) < min) {
				n1 = nums[left];
				n2 = nums[right];
				min = Math.abs(diff);
			}
			
			if (diff > 0)
				right--;
			else
				left++;
		}
		System.out.println(n1 + " " + n2);
	}

}
