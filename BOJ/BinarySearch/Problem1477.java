package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1477 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int l = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] rests = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            rests[i] = Integer.valueOf(st.nextToken());
        }
        rests[n + 1] = l;
        Arrays.sort(rests);

        int left = 1;
        int right = l - 1;

        while (left <= right) {
            // 답이 될 수 있는 최솟값.
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i <= n + 1; i++) {
                int distance = rests[i] - rests[i - 1];
                cnt += distance / mid;
                // 딱 떨어지면은 마지막 위치에 설치할 수 없음.
                if (distance % mid == 0)
                    cnt--;
            }
            if (cnt >= m) { // m보다 크거나 많다면 휴게소 간의 간격을 더 늘릴 수 있다. (구간의 최댓 값)
                left = mid + 1;
            } else { // mid 구간으로 m만큼 휴게소를 설치할 수 없는경우 범위를 좁혀서 설치해야 한다.
                right = mid - 1;
            }
        }
        // 크거나 같은 조건일 때 left 값이 변경된다.
        System.out.println(left);
    }

}
