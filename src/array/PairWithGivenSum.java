package array;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {

    public static void main(String[] args) {
        int sum = 60;
        int diff = 45;

        int[] arr = {15, 60, 30, 10, 20, 25, 30};
        System.out.println(findPairForDiff(arr, diff));
        System.out.println(findPairForSum(arr, sum));

    }

    public static boolean findPairForDiff(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (diff == 0 && map.get(x) > 1) {
                return true;
            }
        }

        if (diff == 0) {
            return false;
        }

        for (int x : arr) {
            if (map.containsKey(diff + x)) {
                System.out.println("Pair Found: (" + x + ", " + (diff + x) + ")");
                return true;
            }
        }
        System.out.println("No Pair found");
        return false;
    }

    public static boolean findPairForSum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : arr) {
            if (sum == 2 * x) {
                if (map.get(x) > 1) {
                    System.out.println("Pair Found2: (" + x + ", " + x + ")");
                    return true;
                }
            } else {
                if (map.containsKey(sum - x)) {
                    System.out.println("Pair Found: (" + x + ", " + (sum - x) + ")");
                    return true;
                }
            }
        }
        System.out.println("No Pair found");
        return false;
    }
}
