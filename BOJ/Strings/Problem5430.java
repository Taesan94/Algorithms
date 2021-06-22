package BOJ.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Problem5430 {

    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> list;

    static void check(String insts) {
        if (insts.contains("D"))
            appendErr();
        else
            appendEmpty();
    }

    static void appendEmpty() {
        sb.append("[]").append('\n');
    }

    static void appendErr() {
        sb.append("error").append('\n');
    }

    // isR = 1 정방향, -1 역방향
    static boolean is_possible(String insts, String[] nums) {
        int isR = 1;
        list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(Integer.valueOf(nums[i]));
        }

        for (char inst : insts.toCharArray()) {
            if (inst == 'R') {
                isR *= -1;
            } else {

                if (list.size() < 1) {
                    appendErr();
                    return false;
                }
                if (isR == 1)
                    list.remove(0);
                else
                    list.remove(list.size() - 1);
            }
        }
        if (isR == -1)
            Collections.reverse(list);
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(br.readLine());

        for (int i = 0; i < tc; i++) {
            String insts = br.readLine();
            int n = Integer.valueOf(br.readLine());

            String num = br.readLine();
            if (n == 0 || num.equals("[]")) {
                check(insts);
            } else if (num.equals("[]")) {
                if (insts.contains("D"))
                    appendErr();
                else
                    appendEmpty();
            } else {
                num = num.substring(1, num.length() - 1);
                String[] nums = num.split(",");
                if (is_possible(insts, nums))
                    sb.append(list).append('\n');
            }
        }
        System.out.print(sb.toString().replaceAll(" ", ""));
    }
}
