package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1300 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        long k = Long.valueOf(br.readLine());

        long l = 1;
        long r = k;
        long result = 0;

        while (l <= r)
        {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }
            System.out.println("l : " + l +" ~ r : " + r + ", mid : " + mid +", cnt : " + cnt);
            if (cnt < k) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
