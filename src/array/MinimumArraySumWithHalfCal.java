package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Two Player take any element from list each taking turn, make it Half and Add again list
 * Find Minimum Sum After K such iterator
 */

public class MinimumArraySumWithHalfCal {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1000);
        list.add(20);
        list.add(7);
        int k = 6;
        minSum(list, k);
    }

    public static void minSum(List<Integer> list, int k) {
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list);
        for (int i = 0; i < k; i++) {
            pq.add((int) Math.ceil(pq.remove() / 2.0d));
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            int t = pq.poll();
            result = result + t;
        }
        System.out.println("result: " + result);
    }
}
