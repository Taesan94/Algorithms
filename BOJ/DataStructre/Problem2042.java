package BOJ.DataStructre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2042 {

    static long[] tree;
    static long[] nums;

    static long init(int start, int end, int node) {
        if (start == end)
            return tree[node] = nums[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    /*
        n보다 큰 2의 거듭제곱 중 가장 작은 수를 찾는다.
        해당 거듭제곱의 2배 크기의 배열을 생성 (2^size 레벨의 2진트리를 생성하기 위함)
    */
    static void initTree(int n) {
        int size = 1;

        while (size < n) {
            size *= 2;
        }
        tree = new long[size * 2];
        init(1, n, 1);
    }

    /*
        start ~ end범위의 합을 저장하고 있는 node
        update 할 인덱스가 포함되어있다면, diff만큼 더해주어라.
     */
    static void update(int start, int end, int node, int update_idx, long diff) {

        // 범위에 속하지 않는 경우.
        if (start > update_idx || end < update_idx)
            return ;
        // 포함되는 경우에는 diff만큼 갱신.
        tree[node] += diff;
        if (start == end) // 마지막 노드 처리
            return ;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, update_idx, diff);
        update(mid + 1, end, node * 2 + 1, update_idx, diff);
    }

    /*
        left ~ right범위에 해당하는 구간합을 찾는다.
        start ~ end범위의 값을 기록하는 node가 left ~ right범위에 포함되는 경우에 합을 더한다.
     */
    static long getSum(int start, int end, int node, int left, int right) {
        if (end < left || start > right) // 범위를 벗어나는 경우
            return (0);
        if (start >= left && end <= right) // 범위에 포함되는 경우
            return tree[node];
        int mid = (start + end) / 2;
        return getSum(start, mid, node * 2, left, right) + getSum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        nums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Long.valueOf(br.readLine());
        }
        initTree(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            if (a == 1) { // b를 c로 바꾸고
                long c = Long.valueOf(st.nextToken());
                long diff = c - nums[b];
                update(1, n, 1, b, diff);
                nums[b] = c;
            } else { // b ~ c의 구간합을 구하기.
                int c = Integer.valueOf(st.nextToken());
                sb.append(getSum(1, n, 1, b, c)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
