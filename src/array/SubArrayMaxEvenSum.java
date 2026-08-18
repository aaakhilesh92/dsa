package array;

//Java program to implement the above approach
import java.util.*;

class SubArrayMaxEvenSum {

    // Function to find the maximum even sum of any subsequence of length K
    static int evenSumK(int arr[], int N, int K) {

        // If count of elements is less than K
        if (K > N) {
            return -1;
        }

        // Stores maximum even subsequence sum
        int maxSum = 0;

        // Stores Even numbers
        ArrayList<Integer> Even = new ArrayList<Integer>();

        // Stores Odd numbers
        ArrayList<Integer> Odd = new ArrayList<Integer>();

        // Traverse the array
        for (int i = 0; i < N; i++) {
            // If current element is an odd number
            if (arr[i] % 2 == 1) {
                // Insert odd number
                Odd.add(arr[i]);
            } else {
                // Insert even numbers
                Even.add(arr[i]);
            }
        }

        // Sort Odd[] array
        Collections.sort(Odd);

        // Sort Even[] array
        Collections.sort(Even);

        // Stores current index Of Even[] array
        int i = Even.size() - 1;
        // Stores current index Of Odd[] array
        int j = Odd.size() - 1;

        while (K > 0) {
            if (K % 2 == 1) {
                // If count of elements in Even[] >= 1
                if (i >= 0) {
                    maxSum += Even.get(i);
                    i--;
                } else { // If count of elements in Even[] array is 0.
                    return -1;
                }
                K--;
            } else if (i >= 1 && j >= 1) { // If count of elements in Even[] and
                                           // // odd[] >= 2
                int even_i = Even.get(i);
                int even_i_1 = Even.get(i - 1);
                int odd_i = Odd.get(i);
                int odd_i_1 = Odd.get(i - 1);
                if (Even.get(i) + Even.get(i - 1) <= Odd.get(j) + Odd.get(j - 1)) {
                    maxSum += Odd.get(j) + Odd.get(j - 1);
                    j -= 2;
                } else {
                    maxSum += Even.get(i) + Even.get(i - 1);
                    i -= 2;
                }
                K -= 2;
            } else if (i >= 1) { // If count of elements in Even[] array >= 2
                maxSum += Even.get(i) + Even.get(i - 1);
                int even_i = Even.get(i);
                int even_i_1 = Even.get(i - 1);
                i -= 2;
                K -= 2;
            } else if (j >= 1) { // If count of elements in Odd[] array >= 2
                int odd_i = Odd.get(i);
                int odd_i_1 = Odd.get(i - 1);
                maxSum += Odd.get(j) + Odd.get(j - 1);
                j -= 2;
                K -= 2;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 10, 3, 5};
        int N = arr.length;
        int K = 3;

        System.out.println(evenSumK(arr, N, K));
    }
}