package recursion;

public class ArraySortedUsingRecursion {

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        if (isSorted(arr, arr.length) == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int isSorted(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (arr[n - 2] > arr[n - 1]) {
            return 0;
        }
        return isSorted(arr, n - 1);
    }
}
