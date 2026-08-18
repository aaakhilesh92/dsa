package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GFG {

    static void printPowerSet(int[] set) {
        int set_size = set.length;
        int pow_set_size = (int) Math.pow(2, set_size);

        int counter, j;
        List<List<Integer>> arr = new ArrayList<>(pow_set_size);
        for (counter = 0; counter < pow_set_size; counter++) {
            List<Integer> subset = new ArrayList<Integer>(set_size);
            for (j = 0; j < set_size; j++) {
                // Check if jth bit in the counter is set If set then print jth element from set
                if ((counter & (1 << j)) > 0) {
                    subset.add(set[j]);
                }
            }
            arr.add(subset);
        }
        Iterator<List<Integer>> itr = arr.iterator();
        while (itr.hasNext()) {
            List<Integer> tempSet = itr.next();
            if (tempSet.size() <= 1 || findGCD(tempSet)) {
                itr.remove();
            }

        }
        for (List<Integer> arr1 : arr) {
            System.out.println(arr1);
        }

    }

    // Driver program to test printPowerSet
    public static void main(String[] args) {
        int[] set = { 3, 4, 5, 6 };
        printPowerSet(set);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd
    static boolean findGCD(List<Integer> arr) {
        boolean gcdPresent = true;
        int gcd = arr.get(0);
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            gcd = gcd(arr.get(i), gcd);
            if (gcd == 1) {
                gcdPresent = false;
                break;
            }
        }

        return gcdPresent;
    }
}