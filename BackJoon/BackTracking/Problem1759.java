package Programmers.BackJoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1759 {

	static int L;
	static int C;
	static int index;
	static String[] alphas;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		L = Integer.valueOf(input[0]);
		C = Integer.valueOf(input[1]);

		alphas = br.readLine().split(" ");
		Arrays.sort(alphas);

		System.out.println(Arrays.toString(alphas));
		for (int i = 0; i <= C-L; i++) {
			index = 0;
			lineup(i, alphas[i]);
		}
		System.out.println(sb.toString());
	}

	private static void lineup(int start, String str) {
		if (index == (L - 1)) {
			//System.out.println("here");
			if(isPossible(str)) {
				sb.append(str + "\n");
			}
		}else {
			for (int i = start + 1; i < C; i++) {
				index++;
				lineup(i, (str + alphas[i]));
			}
		}
		// System.out.println("start : " + start +", str : " + str + ", index : " + index);
		// index == L-1에 걸렸을 때, --해주고 [ start + 1 ~ C ]범위에서 남은 대상을 찾아야 한다.
		// [ start + 1 ~ C ]범위를 다 본 후에, 해당 index의 이전 범위의 값을 찾아야 한다.
		// 즉, index변수는 현재 채워져있는 index를 의미한다.
		index--;
	}

	private static boolean isPossible(String str) {

		int ja = 0;
		int mo = 0;

		for (int i = 0; i < L; i++) {
			char c = str.charAt(i);

			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				mo++;
			else
				ja++;
		}
		if (mo < 1 || ja < 2)
			return false;
		return true;
	}

}
