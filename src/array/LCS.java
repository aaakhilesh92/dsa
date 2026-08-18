package array;

public class LCS {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 60, 41, 50 };
         lis(arr);
        //int arr1[] = { 3, 0, 0, 2, 5, 4, 6 };
        //printRepeating(arr1);
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

    // Function to print duplicates
    static void printRepeating(int arr[]) {
        int size = arr.length;
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

}
