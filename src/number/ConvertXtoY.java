package number;

// Java implementation to convert a number m to n using minimum number of given operations
// Two Operation allowed
// 1. Multiply by m by 2
// 2. or subtract 1 from m

public class ConvertXtoY {
    // function to find minimum number of given operations to convert m to n
    static int convert(int m, int n) {
        if (m == n)
            return 0;

        // only way is to do
        // -1 (m - n) times
        if (m > n) {
            return m - n;
        }

        // not possible
        if (m <= 0 && n > 0) {
            return -1;
        }

        // n is greater and n is odd
        if (n % 2 == 1) {
            // perform '-1' on m (or +1 on n)
            return 1 + convert(m, n + 1);
        } else { // n is even
            // perform '*2' on m (or n / 2 on n)
            return 1 + convert(m, n / 2);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int m = 2, n = 25;
        System.out.println("Minimum number of " + "operations : " + convert(m, n));
    }
}
