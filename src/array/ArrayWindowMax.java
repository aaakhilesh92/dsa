package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
public class ArrayWindowMax {

    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 4, 7, 11, 20, 9};
        // findWindowMaxArr2(arr, 3);
        int[] arr2 = {12, 1, 78, 90, 57, 89, 56};
        // System.out.println();
        printMax(arr2, arr2.length, 3);

    }

    public static void findWindowMaxArr(int[] arr, int k) {
        int size = arr.length - k + 1;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = findWindowMax(arr, i, i + k - 1);
        }
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static int findWindowMax(int[] arr, int start, int end) {
        int max = arr[start++];
        while (start <= end) {
            if (arr[start] > max) {
                max = arr[start];
            }
            start++;
        }
        return max;
    }

    public static void findWindowMaxArr2(int[] arr, int k) {
        int size = arr.length - k + 1;
        int[] result = new int[size];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        int j = 0;
        int t = pq.peek();
        result[j++] = pq.peek();
        pq.remove(arr[0]);
        for (; i < arr.length; i++) {
            pq.add(arr[i]);
            result[j++] = pq.peek();
            pq.remove(arr[i - k + 1]);
        }
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    // A Dequeue (Double ended queue) based method for printing
    // maximum element of all subarrays of size k
    static void printMax(int arr[], int n, int k) {

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> queue = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<>();

        // Process first k (or first window) elements of array
        int i;
        for (i = 0; i < k; ++i) {
            int arr_i = arr[i];
            // For every element, the previous smaller elements are useless so remove them from Qi
            while (!queue.isEmpty() && arr_i >= arr[queue.peekLast()]) {
                // Remove from rear
                queue.removeLast();
            }

            // Add new element at rear of queue
            queue.addLast(i);
        }
        // { 12, 1, 78, 90, 57, 89, 56 };
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            int arr_i = arr[i];
            // The element at the front of the queue is the largest element of previous window, so print it
            list.add(arr[queue.peek()]);

            // Remove the elements which are out of this window
            while ((!queue.isEmpty()) && queue.peek() <= i - k) {
                queue.removeFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!queue.isEmpty()) && arr_i >= arr[queue.peekLast()]) {
                queue.removeLast();
            }

            // Add current element at the rear of Qi
            queue.addLast(i);
        }

        // Print the maximum element of last window
        list.add(arr[queue.peek()]);
        System.out.println(list);
    }

    // Function to print the maximum for every k size sub-array
    static void print_max(int a[], int n, int k) {
        // max_upto array stores the index upto which the maximum element is a[i]
        // i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i]
        // { 12, 1, 78, 90, 57, 89, 56 };
        int[] max_upto = new int[n];

        // Update max_upto array similar to finding next greater element
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && a[s.peek()] < a[i]) {
                max_upto[s.peek()] = i - 1;
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty()) {
            max_upto[s.peek()] = n - 1;
            s.pop();
        }
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            // j < i is to check whether the jth element is outside the window
            while (j < i || max_upto[j] < i + k - 1) {
                j++;
            }
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

}
