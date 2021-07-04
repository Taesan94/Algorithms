package Programmers;

import java.util.HashMap;
import java.util.Map;

public class HotelRoom {

    Map<Long, Long> map = new HashMap<>();

    private long getRoom(long r) {
        if (!map.containsKey(r)) {
            map.put(r, r + 1);
            return (r);
        }
        long next = map.get(r);
        long empty = getRoom(next);
        map.put(r, empty);
        return (empty);
    }

    public long[] solution(long k, long[] room_number) {

        long[] answer = new long[room_number.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = getRoom(room_number[i]);
        }
        return answer;
    }
}