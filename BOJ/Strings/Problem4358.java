package BOJ.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Problem4358 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        String s = "";

        double total = 0;
        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            total += 1.0;
        }

        Iterator itr = map.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String)itr.next();
            System.out.printf("%s %.4f\n", key, (map.get(key) / total) * 100);
        }
    }
}
