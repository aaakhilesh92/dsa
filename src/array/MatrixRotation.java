package array;

public class MatrixRotation {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // ans - { {7, 4, 1}, {8, 5, 2}, {9, 6, 3} };
        rotateMatrixClockwise(matrix);
        displayMatrix(matrix);
        // int matrix2[][] = {{1, 2}, {4, 5}};
        // rotateMatrixClockwise(matrix2);
        // displayMatrix(matrix2);

        int matrix3[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // ans - { {7, 4, 1}, {8, 5, 2}, {9, 6, 3} };
        rotateMatrixAntiClockwise(matrix3);
        displayMatrix(matrix3);

    }

    // In place function to rotate a N x N matrix
    // by 90 degrees in clockwise direction
    static void rotateMatrixClockwise(int matrix[][]) {
        int N = matrix[0].length;
        // Consider all squares one by one printing the matrix on the basis of
        // observations made on indices. Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                // Swap elements of each cycle in clockwise direction
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = temp;
            }
        }
    }

    static void rotateMatrixAntiClockwise(int matrix[][]) {
        int N = matrix[0].length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = temp;
            }
        }
    }
    static void displayMatrix(int mat[][]) {
        int N = mat[0].length;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}