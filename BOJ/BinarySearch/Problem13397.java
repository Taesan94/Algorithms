package BOJ.BinarySearch;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13397 {

    static int n, m;
    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        nums = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
            max = Math.max(max, nums[i]);
        }
        int l = 0;
        int r = max;
        int result = 10000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) {
                r = mid - 1;
                if (mid < result)
                    result = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }

    // 구간의 점수가 mid값 보다 클 수 있는지? 확인한다.
    static boolean isPossible(int mid) {

        int cnt = 1; // 모두 같은 값일 때 구간의 갯수는 1개이다. 3,3,3 이면 3이 최대 이후에는 0...

        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < n; i++) {

            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
            if (max - min > mid) { //만약 구간 점수가 mid보다 크다면..
                // 다음 위치부터 구간을 나누어야 한다........
                cnt++;
                min = nums[i]; // why i ?
                max = nums[i]; // why i ?
            }
        }
        if (cnt <= m)
            return true;
        return false;
    }
}
