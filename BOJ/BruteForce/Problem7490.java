package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Problem7490 {

    static int[] instruct = {' ', '+', '-'};
    static StringBuilder Result = new StringBuilder("");

    static void append(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ' || arr[i] == '-' || arr[i] == '+')
                Result.append((char)arr[i]);
            else
                Result.append(arr[i]);
        }
        Result.append('\n');
    }

    static int get_num(StringBuilder sb, int i) {
        int n1 = 0;
        while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
            n1 = (n1 * 10) + (sb.charAt(i) - '0');
            i++;
        }
        return n1;
    }

    static void calc(int[] arr) {

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (arr[i] == '+' || arr[i] == '-')
                    sb.append((char)arr[i]);
                else
                    sb.append(arr[i]);
            }
        }

        Queue<Integer> nums = new LinkedList<>();
        Queue<Character> instructs = new LinkedList<>();
        for (int i = 0; i < sb.length(); i++) {
            int n = 0;
            while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
                n = (n * 10) + (sb.charAt(i) - '0');
                i++;
            }
            if (n != 0)
                nums.add(n);
            if (i < sb.length() && (sb.charAt(i) == '-' || sb.charAt(i) == '+')) {
                instructs.add(sb.charAt(i));
            }
        }

        int answer = nums.poll();
        while (!instructs.isEmpty()) {
            char instruct = instructs.poll();
            if (instruct == '-')
                answer -= nums.poll();
            else if (instruct == '+')
                answer += nums.poll();
        }
        if (answer == 0)
            append(arr);
    }

    static void find(int[] arr, int seq) {

        int n = arr.length / 2;

        if (seq == n) {
            calc(arr);
            return ;
        }

        for (int i = 0; i < 3; i++) {
            arr[seq * 2 + 1] = instruct[i];
            find(arr, seq + 1);
        }
    }

    static void find_answer(int n) {
        int[] arr = new int[n * 2 - 1];

        for (int i = 0; i < n; i++) {
            arr[i * 2] = i + 1;
        }
        find(arr, 0);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.valueOf(br.readLine());
        for (int i = 0; i < cnt; i++) {
            find_answer(Integer.valueOf(br.readLine()));
            Result.append('\n');
        }
        System.out.println(Result.toString());

    }
}
