package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class KLargestNum {

    public static void getAllKthNumber(int arr[], int k) {
        // Min Heap/Priority Queue
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = arr.length;
        if (n <= k) {
            System.out.println(Arrays.stream(arr).max());
        }
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            int val = arr[i];
            int peek = queue.peek();
            if (val > peek) {
                queue.poll();
                queue.add(val);
            }
        }

        System.out.print(k + " Largest Number: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 11, 2, 30, 4, 15, 19 };
        getAllKthNumber(arr, k);

    }
}
