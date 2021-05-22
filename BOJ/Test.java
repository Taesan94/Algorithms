package BOJ;

public class Test {

    public static void main(String[] args) {
        int e = 7;
        int n = 36391;

        String P = "EX";

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 2; i++) {
            int value = P.charAt(i) - 'A' + 1;
            System.out.println("seq : " + value);

            long first = (long)Math.pow(value, e);
            long answer = first % n;
            System.out.println(answer);

            sb.append(answer);
        }
        System.out.println(sb.toString());

    }
}
