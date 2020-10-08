package Programmers.SummerWinter2018;

public class StationInstall {

	public static void main(String[] args) {

		int n = 10;
		int[] stations = { 2, 5, 8, 9 };
		int w = 1;

		System.out.printf("Result : %d\n", solution(n, stations, w));
	}

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;

		int start = 1;
		int possibleLen = (w * 2) + 1;
		
		
		for (int i = 0; i < stations.length; i++) {
			
			if (start >= stations[i] - w && start <= stations[i] + w) {
				start = stations[i] + w + 1;
				continue;
			}
			
			int end = stations[i] - w;

			if (end < 0)
				end = 0;

			int cnt = (end - start) / possibleLen;

			if ((end - start) % possibleLen != 0)
				cnt++;
			answer += cnt;
			start = stations[i] + w + 1;
		}
		if (start < n) {
			answer += (n - start) / possibleLen;
			if ((n - start) % possibleLen != 0)
				answer++;
		}
		if (start == n)
			answer++;

		return answer;
	}
}
