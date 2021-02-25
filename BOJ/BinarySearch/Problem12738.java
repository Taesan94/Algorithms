package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem12738 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > list.get(list.size() - 1))
                list.add(num);
            else {
                int l = 0;
                int r = list.size() - 1;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) >= num)
                        r = mid;
                    else
                        l = mid + 1;
                }
                list.set(r, num);
            }
        }
        System.out.println(list.size());
    }
}