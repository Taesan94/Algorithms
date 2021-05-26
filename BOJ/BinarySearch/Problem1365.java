package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1365 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] connect = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = Integer.valueOf(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        list.add(connect[1]);

        for (int i = 2; i <= n; i++) {
            int num = connect[i];

            // 큰 값이면 넣어주고 그냥
            if (num > list.get(list.size() - 1))
                list.add(num);
            else { // 작은 값이면 적당한 위치에 삽입하여 list를 재 구성!
                int l = 0;
                int r = list.size() - 1;

                while (l < r) {
                    int mid = (l + r) / 2;

                    if (list.get(mid) >= num)
                        r = mid;
                    else
                        l = mid + 1;
                }
                list.set(r, num);
            }
        }
        System.out.println(n - list.size());
    }
}
