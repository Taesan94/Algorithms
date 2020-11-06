package Programmers.Level2_Retry1;

import java.util.Set;
import java.util.TreeSet;

public class FindPrime {
	
	private static Set<Integer> nums= new TreeSet<>();
	private static int[] permutations;
	private static boolean[] visitPosition;
	
	
	public static void main(String[] args) {
		// System.out.println(solution("17"));
		// System.out.println(solution("011"));
		System.out.println(solution("1234567"));
	}


    public static int solution(String numbers) {
        int answer = 0;

        StringBuilder sb = new StringBuilder("");
        
        for (int i = 1; i <= numbers.length(); i++) {
            visitPosition = new boolean[numbers.length()];
            permutations = new int[i];
        	setPermutation(numbers.toCharArray(), i, 0);
        }
        System.out.println(nums.toString());
        
        for (int num : nums) {
        	if (isPrime(num)) {
        		answer++;
        	}
        }
        return answer;
    }
    
    private static boolean isPrime(int n) {
    	if (n <= 1)
    		return false;
    	for (int i = 2; i <= (int)Math.sqrt(n); i+=2) {
    		if (n % i == 0)
    			return false;
    	}
    	return true;
    }
    
	private static void setPermutation(char[] arr, int amount, int cnt) {

		if (cnt == amount) {
			StringBuilder sb = new StringBuilder("");
			for (int p : permutations) {
				sb.append(arr[p]);
			}
			nums.add(Integer.valueOf(sb.toString()));
			return ;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visitPosition[i]) {
				visitPosition[i] = true;
				permutations[cnt] = i;
				setPermutation(arr, amount, cnt + 1);
				visitPosition[i] = false;
			}
		}
	}
	
}
