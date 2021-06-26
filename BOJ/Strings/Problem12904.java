package BOJ.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem12904 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        while (s.length() != t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                StringBuilder sb = new StringBuilder(t.substring(0, t.length() - 1)).reverse();
                t = sb.toString();
            }
            // System.out.println("t : " + t);
        }

        if (s.equals(t))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
