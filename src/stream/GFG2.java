package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GFG2 {

    static void printPowerSet(int[] set) {
        int ssSize = set.length;
        int powerSetSize = (int) Math.pow(2, ssSize);
        List<List<Integer>> subSet = new ArrayList<>(powerSetSize);
        int counter, j;
        for (counter = 0; counter < powerSetSize; counter++) {
            List<Integer> subsetTemp = new ArrayList<>();
            for (j = 0; j < ssSize; j++) {
                if ((counter & (1 << j)) > 0) {
                    subsetTemp.add(set[j]);
                }
            }
            subSet.add(subsetTemp);
        }

        Iterator<List<Integer>> itr = subSet.iterator();
        while (itr.hasNext()) {
            List<Integer> tempSet = itr.next();
            if (tempSet.size() <= 1 || findGCD(tempSet)) {
                itr.remove();
            }

        }
        for (List<Integer> arr1 : subSet) {
            System.out.println(arr1);
        }
    }

    // Driver program to test printPowerSet
    public static void main(String[] args) {
        int[] set = { 3, 4, 5, 6 };
        printPowerSet(set);
    }

    static int getGCD(int a, int b) {
        if (a == 0)
            return b;
        return getGCD(b % a, a);
    }

    // Function to find gcd
    static boolean findGCD(List<Integer> arr) {
        boolean result = true;
        int n = arr.size();
        int gcd = arr.get(0);
        for (int i = 1; i < n; i++) {
            gcd = getGCD(gcd, arr.get(i));
            if (gcd == 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}