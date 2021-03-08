package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1253 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(nums);

        int l, r, sum, result = 0;

        for (int i = 0; i < n; i++) {

            l = 0;
            r = n - 1;

            while (true) {
                if (l == i)
                    l++;
                if (r == i)
                    r--;
                if (l >= r)
                    break;
                sum = nums[l] + nums[r];

                if (sum > nums[i])
                    r--;
                else if (sum == nums[i]) {
                    result++;
                    break;
                } else if (sum < nums[i]) {
                    l++;
                }
            }
        }
        System.out.println(result);
    }
}
