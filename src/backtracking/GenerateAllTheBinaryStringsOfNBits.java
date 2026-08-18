package backtracking;

public class GenerateAllTheBinaryStringsOfNBits {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n];
        generateAllBinaryStrings(arr, 0, n);
    }

    private static void generateAllBinaryStrings(int[] arr, int i, int n) {
        if (i == n) {
            printTheArray(arr, n);
            return;
        }

        arr[i] = 0;
        generateAllBinaryStrings(arr, i + 1, n);
        arr[i] = 1;
        generateAllBinaryStrings(arr, i + 1, n);
    }

    // Function to print the output
    private static void printTheArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
