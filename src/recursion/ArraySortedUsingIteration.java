package recursion;

public class ArraySortedUsingIteration {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        if (isSorted(arr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isSorted(int[] arr) {
        int length = arr.length;
        if (length == 0 || length == 1) {
            return true;
        }
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
