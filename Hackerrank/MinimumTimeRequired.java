package Hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumTimeRequired {

	public static void main(String[] args) {
		long[] machines = {
				// 2, 3
				1, 3, 4
		};
		
		System.out.println("result : " + minTime(machines, 10));

	}

	// Complete the minTime function below.
	static long minTime(long[] machines, long goal) {
		Arrays.sort(machines);
		return binarySearch(0, (machines.length * goal), goal, machines);
	}
	
	static long binarySearch(long l, long r, long goal, long[] machines) {
		
		while (l < r) {
			long mid = (l + r) / 2;
			long wkTime = 0;
			for (int i = 0; i < machines.length; i++) {
				if (machines[i] > mid)
					break ;
				wkTime += (mid / machines[i]); 
			}
			if (wkTime >= goal) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	

}
