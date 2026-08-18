package array;

public class MatrixMultiplication {

    public static void main(String[] args) throws Exception {

        // Initial matrix 1 and matrix 2
        int matrix1[][] = {{1, 2, 3}, {4, 5, 6}};
        int matrix2[][] = {{7, 8}, {9, 10}, {11, 12}};

        matrixMultiplication(matrix1, matrix2);

    }

    private static void matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;
        if (c1 != r2) {
            System.out.println("Multiplication not possible");
            return;
        }
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < r2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Result matrix" + " is ");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
