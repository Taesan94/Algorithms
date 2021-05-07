package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2110 {

    static int N, C;
    static int[] Pos;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        Pos = new int[N];

        for (int i = 0; i < N; i++)
            Pos[i] = Integer.valueOf(br.readLine());

        Arrays.sort(Pos);

        // System.out.println(Arrays.toString(Pos));
        int l = 1;
        int r = Pos[N - 1] - Pos[0]; // 최대거리
        //  s  sSystem.out.println("r :  " + r);
        int result = 0;

        while (l <= r) {
            int cnt = 1;
            int mid = (l + r) / 2;
            int start = Pos[0];

            for (int i = 1; i < N; i++) {
                if ((Pos[i] - start) >= mid) {
                    cnt++;
                    start = Pos[i];
                }
            }
            System.out.println("l : " + l +", r : " + r + ", mid : " + mid+", cnt : " + cnt);
            if (cnt >= C) { // 해당 거리가 가능하다면? 더 큰범위에서 답 찾기
                l = mid + 1;
                result = Math.max(result, mid);
            } else { // 아니라면 더 작은 범위에서 답 찾기
                r = mid;
                if (l == r)
                    break;
            }
        }

        System.out.println(result);
    }
}
