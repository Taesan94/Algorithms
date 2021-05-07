package Programmers;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HanoiTop {

    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(new InputStreamReader(System.in));

        System.out.print("n을 입력해 주세요 : ");
        solution(Integer.valueOf(scan.nextLine()));

        for(int[] answer : result)
            System.out.println(Arrays.toString(answer));
    }

    public static int[][] solution(int n) {
        int[][] answer = {};

        hanoi(n, 1, 3, 2);

        answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        return answer;
    }
    /* 하노이탑의 재귀 과정.
        n개의 원판을 옮기기 위해서는 n - 1개의 원판에 대해서 2번 재귀한다.
         ex) n = 3일 때 , 각 기둥을 {a, b, c}라고 한다면
         hanoi(3, a, c, b) => 3개의 원판을 a에서 c로 옮긴다. (b를 거쳐서 간다.)
           - hanoi(2, a, b, c) => 2개의 원판을 a에서 b로 먼저 옮긴다. (c를 거쳐)
           - a에 있는 가장 큰 원판을 c로 옮긴다.
           - hanoi(2, b, c, a) => b에 있는 2개의 원판을 다시 c로 옮긴다.

         * 탈줄조건(기저사례, base case)는 n == 1인 경우이다.
          1개의 원판은, 그냥 옮기면 끝.
     */
    private static void hanoi(int n, int from, int to, int via) {

        if (n == 1) {
            result.add(new int[] {from, to});
            return ;
        }

        hanoi(n - 1, from, via, to);
        result.add(new int[] {from, to});
        hanoi(n - 1, via, to, from);
    }

}
