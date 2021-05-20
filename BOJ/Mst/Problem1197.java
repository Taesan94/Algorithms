package BOJ.Mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1197 {

    static int[] parents;

    static int getParent(int v) {
        int p = parents[v];

        if (p != v)
            return getParent(p);
        return p;
    }

    static void union(int from, int to) {
        int p1 = getParent(from);
        int p2 = getParent(to);

        int min = (p1 < p2) ? p1 : p2;
        int max = (p1 > p2) ? p1 : p2;

        // idx의 부모는 value이다. 가장 최상위 부모로 변경.
        parents[max] = getParent(min);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());

        parents = new int[v + 1];

        for (int i = 1; i <= v; i++)
            parents[i] = i;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            String s = br.readLine();
            int[] nums = new int[3];

            int j = 0;
            int seq = 0;
            boolean neg = false;
            int value = 0;
            while (j < s.length()) {
                if (s.charAt(j) == '-') {
                    value = 0;
                    neg = true;
                }
                else if (s.charAt(j) == ' ') {
                    nums[seq++] = value;
                    value = 0;
                } else
                    value = value * 10 + s.charAt(j) - '0';
                j++;
            }
            if (neg)
                value *= -1;
            nums[2] = value;
            pq.add(new Vertex(nums[0], nums[1], nums[2]));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();

            if (getParent(curr.from) != getParent(curr.to)) {
                answer += curr.value;
                union(curr.from, curr.to);
            }
        }
        System.out.println(answer);
    }

    static class Vertex implements Comparable<Vertex> {
        int from;
        int to;
        int value;

        public Vertex(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public int compareTo(Vertex o) {
            return this.value - o.value;
        }
    }
}
