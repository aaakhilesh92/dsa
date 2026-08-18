package array;

public class ReverseSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 6;
        reverse(arr, k);
        for (int x : arr) {
            System.out.print(x + ",");
        }
    }

    public static int[] reverse(int arr[], int k) {
        if (k > arr.length) {
            return null;
        }
        int length = arr.length;
        int start = 0;
        int end = k - 1;
        while (start < length) {
            reverse_subarray(arr, start, end);
            start = end + 1;
            if (end + k < length) {
                end = end + k;
            } else {
                end = length - 1;
            }
        }
        return arr;
    }

    private static void reverse_subarray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
