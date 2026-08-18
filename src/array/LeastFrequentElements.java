package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeastFrequentElements {
    public static void main(String[] args) {
        int[] arr = {10, 22, 33, 10, 20, 22, 33, 20};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // for (int x : arr) {
        // map.put(x, map.getOrDefault(x, 0) + 1);
        // }
        int f = 0;
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int leastFreq = arr.length + 1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (leastFreq > e.getValue()) {
                leastFreq = e.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (leastFreq == e.getValue()) {
                list.add(e.getKey());
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
