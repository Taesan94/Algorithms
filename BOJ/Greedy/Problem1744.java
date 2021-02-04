package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1744 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(br.readLine());

			if (num <= 0)
				minus.add(num);
			else
				plus.add(num);
		}
		
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		int result = 0;
		result += getMax(plus);
		result += getMax(minus);
		System.out.println(result);
	}
	
	static int getMax(List<Integer> list) {
		int max = 0;
		
		for (int i = 0; i < list.size(); i++) {
			int j = i + 1;
			if (j < list.size()) {
				if (list.get(i) == 1 || list.get(j) == 1)
					max += list.get(i++) + list.get(j);
				else
					max += list.get(i++) * list.get(j);
			}
			else
				max += list.get(i);
		}
		return max;
	}

}
