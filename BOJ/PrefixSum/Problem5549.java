package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5549 {

    static int N, M, K;
    static char[][] Map;
    static Info[][] Infos;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(br.readLine());

        Map = new char[M + 1][N + 1];
        // 각 좌표에 몇개의 구역이 존재하는지 기록.
        Infos = new Info[M + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Infos[0][i] = new Info(0, 0, 0);
        }

        for (int i = 0; i <= M; i++) {
            Infos[i][0] = new Info(0, 0, 0);
        }

        for (int i = 1; i <= M; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                Map[i][j] = s.charAt(j - 1);

                Info left= Infos[i][j - 1];
                Info up= Infos[i - 1][j];
                Info lu = Infos[i - 1][j - 1];

                Info curr = new Info(0, 0, 0);
                curr.add(left);
                curr.add(up);
                curr.minus(lu);

                if (Map[i][j] == 'J') {
                    curr.jungle += 1;
                } else if (Map[i][j] == 'O') {
                    curr.oasis += 1;
                } else if (Map[i][j] == 'I') {
                    curr.ice += 1;
                                                                                                                                       }
                Infos[i][j] = curr;
            }
        }

//        for (int i = 0; i <= M; i++) {
//            System.out.println(" ####### [ " + i +" ] ####### ");
//            for (int j = 0; j <= N; j++) {
//                System.out.println(Infos[i][j].toString());
//            }
//        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());

            Info sum =  new Info(0, 0, 0);
            sum.add(Infos[x2][y2]);
            sum.minus(Infos[x1 - 1][y2]);
            sum.minus(Infos[x2][y1 - 1]);
            sum.add(Infos[x1 - 1][y1 - 1]);

            sb.append(sum.jungle +" " + sum.oasis +" " + sum.ice + "\n");
        }
        System.out.println(sb.toString());
    }

    static class Info {
        int jungle;
        int oasis;
        int ice;

        public Info(int jungle, int oasis, int ice) {
            this.jungle = jungle;
            this.oasis = oasis;
            this.ice = ice;
        }

        public void add(Info b) {
            jungle += b.jungle;
            oasis += b.oasis;
            ice += b.ice;
        }

        public void minus(Info b) {
            jungle -= b.jungle;
            oasis -= b.oasis;
            ice -= b.ice;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "jungle=" + jungle +
                    ", oasis=" + oasis +
                    ", ice=" + ice +
                    '}';
        }
    }

    static void print(char[][] arr) {
        System.out.println("### Print ###");
        for(char[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

}
