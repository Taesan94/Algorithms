package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.*;

public class Problem1756 {

    static int d,n,start,finish;
    static int num[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        num = new int[d];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < d; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 상단의 지름이 더 작다면, 현재 화덕크기에 맞는 도우는 넣을 수 없다.
        // 따라서, 위쪽의 작은 화덕에 맞게끔 변경해주는 작업.
        for (int i = 1; i < d; i++) {
            if (num[i - 1] < num[i])
                num[i] = num[i - 1];
        }

        st = new StringTokenizer(br.readLine());
        finish = d;
        for (int i = 0; i < n; i++) {
            start = 0;
            find(Integer.parseInt(st.nextToken()));
            finish--; // 찾은 위치보다 한칸위로 이동.
            if (finish < 0) {
                break;
            }
        }
        System.out.println(finish + 1); // 화덕인덱스를 0부터 세서 마지막에는 + 1 해줌
    }

    private static void find(int dow) {
        while (start < finish) {
            int mid = (start + finish) / 2;
            if(num[mid] < dow) { // 화덕이 도우크기보다 작다면?, 더 높이에서 봐야한다. 더 높은 위치는 낮은 인덱스에 위치한다.
                finish = mid;
            }
            else {
                start = mid + 1; // 화덕이 도우보다 크거나 같다면?, 더 작은 값이 될 수 있는걸 찾아본다. +1을 하는 이유는, 홀수 + 짝수의 경우때문에..
            }
        }
    }


}
