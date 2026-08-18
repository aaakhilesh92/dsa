package array;

/*
 *  Pascal's Triangle -  O(n^2) time and O(n^2) extra space
 *     1 
 *    1 1 
 *   1 2 1 
 *  1 3 3 1 
 * 1 4 6 4 1 
 */

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        printPascal(n);
    }

    public static void printPascal(int n) {
        // An auxiliary array to store generated pascal triangle values
        int[][] arr = new int[n][n];

        // Iterate through every i and print integer(s) in it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Every i has number of integers equal to i number
            for (int j = 0; j <= i; j++) {
                // First and last values in every row are 1
                if (i == j || j == 0) {
                    arr[i][j] = 1;
                } else { // Other values are sum of values just above and left of above
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
