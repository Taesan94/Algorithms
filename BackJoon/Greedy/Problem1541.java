package Programmers.BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1541 {

	static void solution2() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] strArr1 = input.split("\\-");
		
		System.out.println(Arrays.toString(strArr1));

		int minSum = 0;
		for (int i = 0; i < strArr1.length; i++) {

			String[] strArr2 = strArr1[i].split("\\+");
			System.out.println(Arrays.toString(strArr2));

			int tempSum = 0;
			for (String x : strArr2) {
				tempSum += Integer.parseInt(x);
			}

			if (i == 0) tempSum *= -1;

			minSum -= tempSum;
		}

		System.out.println(minSum);
	}

	public static void main(String[] args) throws Exception {
		
		solution2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// +일 때는 그냥 더한다.
		// -일때 괄호열어서 뒤의 '+'를 다 더한다음에 닫아준다.
		String p = br.readLine();

		Deque<Integer> nums = new ArrayDeque<>();
		Queue<Character> opers = new LinkedList<>();
		for (int i = 0; i < p.length(); i++) {

			StringBuilder num = new StringBuilder("");
			while (i < p.length() && Character.isDigit(p.charAt(i))) {
				num.append(p.charAt(i));
				i++;
			}
			nums.add(Integer.valueOf(num.toString()));
			if (i < p.length())
				opers.add(p.charAt(i));
		}
		if (nums.size() == 1)
			System.out.println(nums.poll());

		while (!opers.isEmpty() && !nums.isEmpty()) {
			char oper = opers.poll();

			int result = 0;
			int num1 = nums.poll();
			int num2 = nums.poll();

			if (oper == '+') {
				result += num1 + num2;
			} else {
				while (!opers.isEmpty() && opers.peek() == '+' && !nums.isEmpty()) {
					num2 += nums.poll();
				}
				result = num1 - num2;
			}
			if (nums.size() > 0) {
				nums.addFirst(result);
			} else {
				System.out.println(result);
			}
		}
	}

}
