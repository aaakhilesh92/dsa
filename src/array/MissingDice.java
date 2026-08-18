package array;

public class MissingDice {

    public static void main(String[] args) {
        int[] A = {3, 2, 4, 3};
        int F = 2, M = 4;
        int[] result = solution(A, F, M);
        for (int x : result) {
            System.out.print(x + ", ");
        }
        System.out.println();
        int[] B = {1, 5, 6};
        F = 4;
        M = 3;
        int[] result1 = solution(B, F, M);
        for (int x : result1) {
            System.out.print(x + ", ");
        }
        int[] C = {1, 2, 3, 4};
        F = 4;
        M = 6;
        int[] result2 = solution(C, F, M);
        for (int x : result2) {
            System.out.print(x + ", ");
        }
    }

    public static int[] solution(int[] A, int F, int M) {
        if (F < 0 || M < 1 || M > 6) {
            return new int[]{0};
        }
        int[] res = new int[F];
        int totalRolls = A.length + F;
        int sum = 0;

        for (int el : A) {
            sum += el;
        }

        int numForF = (M * totalRolls) - sum;

        if (F > numForF || numForF / F > 6) {
            return new int[]{0};
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = numForF / F--;
            numForF -= res[i];
        }
        return res;
    }
}
