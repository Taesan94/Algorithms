package Programmers.KAKAO_INTERNSHIP_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ModifierMax {

	public static void main(String[] args) {

		String expression = "50*6-3*2";// "100-200*300-500+20"; // 
		System.out.println("Result : " + solution(expression));

	}

	static int cnt = 0;
	static long max = 0;
	static int[] pos;
	static boolean[] visited;

	static String[] modifiers = new String[3];
	static List<String> comb = new ArrayList<>();
	static List<String> nums = new LinkedList<>();
	static List<Character> opers = new LinkedList<>();


	public static long solution(String expression) {

		Arrays.fill(modifiers, "x");

		if (expression.contains("-")) {
			modifiers[0] = "-";
			cnt++;
		}

		if (expression.contains("+")) {
			modifiers[1] = "+";
			cnt++;
		}

		if (expression.contains("*")){
			modifiers[2] = "*";
			cnt++;
		}

		pos = new int[3];
		visited = new boolean[3];

		StringBuilder sb = new StringBuilder("");

		for (char c : expression.toCharArray()) {

			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				opers.add(c);
				nums.add(sb.toString());
				sb = new StringBuilder("");
			}
		}
		nums.add(sb.toString());

		makeModifier(0, "");

		// 1. 연산자로 수식 만들기
		// 2. 해당 수식을 pop해가면서 해당하는 경우 모두 계산하기. .. 순서대로
		for (int i = 0; i < comb.size(); i++) {
			String modi = comb.get(i);

			Queue<Character> q = new LinkedList<>();

			for (char c : modi.toCharArray()) {
				q.add(c);
			}

			String result = calcValue(q);
			max = Math.max(Math.abs(Long.valueOf(result)), max);
		}

		return max;
	}

	static String calcValue(Queue<Character> q) {

		List<String> numsCp = new LinkedList<>(nums);
		List<Character> opersCp = new LinkedList<>(opers);

		while (!q.isEmpty()) {

			char seqOp = q.poll();

			for (int i = 0; i < opersCp.size(); i++) {

				if (seqOp == opersCp.get(i)) {
					numsCp.add(i, String.valueOf(calc(numsCp.remove(i), numsCp.remove(i), seqOp)));
					opersCp.remove(i);
					i--;
				}
			}
		}
		return numsCp.get(0);
	}

	static long calc(String left, String right, char oper) {

		Long lValue = Long.valueOf(left);
		Long rValue = Long.valueOf(right);

		if (oper == '-') {
			return lValue - rValue;
		} else if (oper == '+') {
			return lValue + rValue;
		} else {
			return lValue * rValue;
		}
	}


	static void makeModifier(int seq, String modi) {

		if (seq == cnt) {
			comb.add(modi);
			return ;
		}

		for (int i = 0; i < 3; i++) {
			if (!visited[i] && !modifiers[i].equals("x")) {
				visited[i] = true;
				pos[seq] = i;
				makeModifier(seq + 1, modi + modifiers[i]);
				visited[i] = false;
			}
		}
	}
}
