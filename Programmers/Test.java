package Programmers;

public class Test {

    public static void main(String[] args) {


        int[] p = {100000, 10000, 1000};

        int[] dis = {30, 25, 10};

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            double d = p[i] * dis[i] / 100;
            System.out.println(" dis " + d);
            int price = p[i] - (int)d;
            System.out.println("price : " + price);
            answer += price;
        }
        System.out.println("answer : " + answer);


    }
}
