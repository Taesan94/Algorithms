package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2470 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(nums);

        int l = 0;
        int r = N - 1;
        int min = Math.abs(nums[l] + nums[r]);
        int[] answer = new int[2];

        while (l < r) {
            int len = nums[l] + nums[r];

            if (Math.abs(len) <= min) {
                answer[0] = nums[l];
                answer[1] = nums[r];
                min = Math.abs(len);
            }

            if (len >= 0)
                r--;
            else
                l++;
        }
    }
}
