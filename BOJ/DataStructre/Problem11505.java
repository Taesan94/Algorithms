package BOJ.DataStructre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11505 {

    private static int N;
    static long[] nums;
    static long[] tree;
    static int MOD = 1000000007;

    static int getSize() {
        int size = 1;

        while (size <= N) {
            size *= 2;
        }
        return size * 2;
    }

    static long init(int s, int e, int node) {
        if (s == e)
            return tree[node] = nums[s];
        int mid = (s + e) / 2;
        return tree[node] = (init(s, mid, node * 2) * init(mid + 1, e, node * 2 + 1)) % MOD;
    }

    static long update(int s, int e, int node, int idx, long val) {
        // 범위에 포함되는 값은 모두 변경.
        if (s > idx || e < idx) {
            return tree[node];
        }
        if (s == e)
            return tree[node] = val;
        int mid = (s + e) / 2;
        return tree[node] = (update(s, mid, node * 2, idx, val) * update(mid + 1, e,node * 2 + 1, idx, val)) % MOD;
    }

    static long getMul(int s, int e, int left, int right, int node) {
        if (s > right || e < left)
            return 1;
        else if (s >= left && e <= right)
            return tree[node];
        int mid = (s + e) / 2;
        return (getMul(s, mid, left, right, node * 2) * getMul(mid + 1, e, left, right, node * 2 + 1)) * MOD;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int size = getSize();
        nums = new long[N + 1];
        tree = new long[size];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.valueOf(br.readLine());
        }
        init(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            long c = Long.valueOf(st.nextToken());
            if (a == 1) {
                nums[b] = c;
                update(1, N, 1, b, c);
                // System.out.println("tree :" + Arrays.toString(tree));
            } else if (a == 2){
                sb.append(getMul(1, N, b, (int)c, 1)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
