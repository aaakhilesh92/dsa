package number;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibNthNumberRec(n));
        System.out.println(fibNthNumberIterative(n));
        fibRecursion(n);
        System.out.println("fibTailRecursion(" + n + ") = " + fibTailRecursion(n, 0, 1));
    }

    static int fibNthNumberRec(int n) {
        // Base Case
        if (n <= 1) {
            return n;
        }
        // Recursive call
        return fibNthNumberRec(n - 1) + fibNthNumberRec(n - 2);
    }

    static int fibNthNumberIterative(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static void fibRecursion(int n) {
        // Print the first N numbers
        for (int i = 0; i <= n; i++) {
            System.out.print(fibNthNumberRec(i) + " ");
        }
        System.out.println();
    }

    static int fibTailRecursion(int n, int a, int b) {

        if (n == 0)
            return a;
        if (n == 1)
            return b;
        return fibTailRecursion(n - 1, b, a + b);
    }
}
