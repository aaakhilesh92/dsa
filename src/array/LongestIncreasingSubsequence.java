package array;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        lis(arr);
    }

    public static void lis(int arr[]) {
        int len = 1;
        int n = arr.length;
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int i_value = arr[i];
            for (int j = 0; j < i; j++) {
                int j_value = arr[j];
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            if (lis[i] > len) {
                len = lis[i];
            }
        }
        System.out.println("Length of lis is " + len);
    }
}
