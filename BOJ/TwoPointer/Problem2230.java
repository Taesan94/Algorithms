package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2230 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.valueOf(br.readLine());

        Arrays.sort(nums);

        int s = 0;
        int e = 0;
        int result = Integer.MAX_VALUE;

        while (s <= e && e < n) {
            int value = nums[e] - nums[s];
            if (value < m) {
                e++;
            } else {
                result = Math.min(result, value);
                s++;
            }
        }
        System.out.println(result);
    }
}
