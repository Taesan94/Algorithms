package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003_retry {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수열의 크기
		int N = Integer.valueOf(st.nextToken());
		// 찾고자하는 수
		int M = Integer.valueOf(st.nextToken());
		// 수열을 저장
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
		}

		int result = 0;

		// pointer1
		int l = 0;
		// pointer2
		int r = 0;
		// 구간 합을 저장할 변수
		int s = 0;

		// pointer2즉, right위치의 포인터가 끝에 도달할때까지 반복.
		while (true) {

			if (s >= M) { // 구간 합이 크거나 같은 경우에는 pointer1, 즉 left 위치의 값을 빼고 left를 이동시킨다.
				s -= nums[l++];
			} 
			else if (r == N) // 마지막 s == M 조건을 한번더 보기 위해 종료조건을 여기다 포함시킨다. ex) 6 13에 2 3 5 7 11 13일 때 마지막 13도 볼 수 있도록
				break;
			else
				s += nums[r++]; // 구간합보다 작은경우에는 그 합을 늘려간다.
			if (s == M) // 원하는 결과를 찾은경우!
				result++;
		}
		System.out.println(result);
	}

}
