package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1342 {

    static int Cnt;
    static String S;

    static boolean check(char[] word) {
        // System.out.println(Arrays.toString(word));
        for (int i = 1; i < word.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            if (word[left] != word[i] && word[i] != word[right])
                continue;
            return false;
        }
        return true;
    }

    static void permutation(int seq, boolean[] visited, char[] word) {

        if (seq == S.length() && check(word)) {
            Cnt++;
            return ;
        }

        for (int i = 0; i < S.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                word[seq] = S.charAt(i);
                permutation(seq + 1, visited, word);
                visited[i] = false;
            }
        }
    }

    static int factorial(int n) {
        int result = 1;

        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        int[] cnts = new int[26];

        for (char c : S.toCharArray()) {
            cnts[c - 'a']++;
        }

        boolean[] visited = new boolean[S.length()];
        char[] word = new char[S.length()];
        permutation(0, visited, word);

        for (int i = 0; i < 26; i++) {
            if (cnts[i] > 1) {
                Cnt /= factorial(cnts[i]);
            }
        }
        System.out.println(Cnt);

    }
}
