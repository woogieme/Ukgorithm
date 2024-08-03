package Programmers.Level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {

        TreeMap<Integer, Integer> tMap = new TreeMap<>();

        for (int i = 0; i < tangerine.length; i++) {

            if (tMap.containsKey(tangerine[i])) {
                tMap.put(tangerine[i], tMap.get(tangerine[i]) + 1);
            } else {
                tMap.put(tangerine[i], 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(tMap.keySet());

        keySet.sort((o1, o2) -> tMap.get(o2).compareTo(tMap.get(o1)));

        int result = 0;
        int count = 0;
        for (Integer key : keySet) {
            if (result >= k) {
                break;
            }
            result += tMap.get(key);
            count++;
        }

        return count;
    }
}