package array;

/* A and B are taking element from either end of array
 * Both are trying to maximize their total sum
 * find minimum different between A'sum and B'sum 
 */

public class MinimumDiffBwASumAndBSum {

    public static void main(String[] args) {

        int[] arr = { -1, 100, 4, -5 };
        int front = 0;
        int rear = arr.length - 1;
        int sum_a = 0;
        int sum_b = 0;
        boolean aTurn = true;
        while (front <= rear) {
            if (aTurn) {
                if (arr[front] > arr[rear]) {
                    sum_a += arr[front++];
                } else {
                    sum_a += arr[rear--];
                }
                aTurn = false;
            } else {
                if (arr[front] > arr[rear]) {
                    sum_b += arr[front++];
                } else {
                    sum_b += arr[rear--];
                }
                aTurn = true;
            }
        }
        System.out.println(Math.abs(sum_a - sum_b));
    }
}