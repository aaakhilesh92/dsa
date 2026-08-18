package array;

//Java program to rotate an array by d elements
public class RotateAnArray {
    /* Function to left rotate arr[] of size n by d */
    public static void leftRotate(int arr[], int d, int n) {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public static void rightRotate(int arr[], int d) {
        int n = arr.length;
        d = n - d % n;
        leftRotate(arr, d, n);
    }
    public static void rightRotate(int arr[], int d, int n) {
        if (d == 0)
            return;

        d = d % n;

        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
    }

    public static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    public static int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static void leftRotate(int arr[], int d) {
        if (d == 0)
            return;

        int n = arr.length;
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        // leftRotate(arr, 3, arr.length);
        rightRotate(arr, 3);
        printArray(arr, arr.length);
    }
}