package array;

import java.util.HashSet;

//Java Program to find longest consecutive subsequence This Program uses Priority Queue
class LISConsecutiveNum {
    // Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i) {
            S.add(arr[i]);
        }

        // check each possible sequence from the start then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting element of a sequence
            if (!S.contains(arr[i] - 1)) {
                // Then check for next elements in the sequence
                int currNum = arr[i];
                int count = 0;
                while (S.contains(currNum + count)) {
                    count++;
                }

                // update optimal length if this length is more
                if (ans < count) {
                    ans = count;
                }
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = { 1, 19, 13, 10, 4, 21 };
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
    }
}
