package Programmers.Level3;

public class Problem1 {

	public static void main(String[] args) {

		int n = 6;
		int[] stations = {};
		int w = 1;

		solution(n, stations, w);

	}

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;

		int size = (w * 2) + 1;
		int start = 1;
		int end = 0;
		int len = 0;

		for (int i=0; i < stations.length; i++) {

			end = stations[i] - w;
			len = end - start;
			start = stations[i] + w + 1;

			if (len < 1)
				continue;
			
			answer += len / size;
			
			if (len % size != 0) answer++;
		}
		
		len = n - start;
		if (len > 0) {
			answer += len / size;
			if (len % size != 0)
				answer++;
		}
		System.out.println(answer);
		return answer;
	}

}
