package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SymmetricPair {

    public static void main(String[] args) {
        int[][] arr = {{11, 20}, {30, 40}, {30, 20}, {5, 10}, {40, 30}, {10, 5}};
        findPair(arr);
        findPair2(arr);

    }

    public static void findPair(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] subArr : arr) {
            int first = subArr[0];
            int second = subArr[1];
            Integer val = map.get(second);
            if (val != null && val.equals(first)) {
                System.out.println("Found Pair: [" + second + ", " + first + "]");
            } else {
                map.put(first, second);
            }
        }
    }
    public static void findPair2(int[][] arr) {
        Set<String> set = new HashSet<>();
        for (int[] subArr : arr) {
            int first = subArr[0];
            int second = subArr[1];
            if (set.contains(second + "_" + first)) {
                System.out.println("Found Pair: [" + second + ", " + first + "]");
            } else {
                set.add(first + "_" + second);
            }
        }
    }
}
