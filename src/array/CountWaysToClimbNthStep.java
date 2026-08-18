package array;

public class CountWaysToClimbNthStep {
    static int countWays(int n, int m) {
        int res[] = new int[n + 1];
        int temp = 0;
        res[0] = 1;

        for (int i = 1; i <= n; i++) {
            int s = i - m - 1;
            int e = i - 1;
            if (s >= 0) {
                temp -= res[s];
            }
            temp += res[e];
            res[i] = temp;
        }
        return res[n];
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 7, m = 2;
        System.out.println("Number of ways = " + countWays(n, m));
        System.out.println("Number of ways = " + countWays2Steps(n));
    }
    public static int countWays2Steps(int n) {
        return fibonacci(n + 1);
    }
    private static int fibonacci(int n) {
        int result = 0;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
