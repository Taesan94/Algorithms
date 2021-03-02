package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14921 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        int s = 0;
        int e = n - 1;
        int result = nums[s] + nums[e];

        while (s != e) {
            int value = nums[s] + nums[e];
            if (Math.abs(value) < Math.abs(result))
                result = value;
            if (value > 0)
                e--;
            else if (value < 0)
                s++;
            else
                break;
        }
        System.out.println(result);
    }
}
