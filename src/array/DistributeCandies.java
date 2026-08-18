package array;

public class DistributeCandies {

    public static void main(String[] args) {
        int n = 10000, k = 3;
        candies(n, k);
        System.out.println();
        candies2(n, k);
    }

    public static void candies(int n, int k) {
        int[] arr = new int[k];
        int i = 0;
        int curr_count = 1;
        int loop = 0;
        while (n > 0) {
            loop++;
            int index = i % k;
            if (curr_count >= n) {
                curr_count = n;
            }
            arr[index] += curr_count;
            n = n - curr_count;
            curr_count++;
            i++;
        }
        System.out.println("loop:" + loop);
        for (int x : arr)
            System.out.print(x + " ");
    }

    static void candies2(int n, int k) {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        long[] arr = new long[k];

        int low = 0, high = n;

        // Do a binary search to find the number whose
        // sum is less than N.
        int loop = 0;
        while (low <= high) {
            loop++;
            // Get mid
            int mid = (low + high) >> 1;
            int sum = (mid * (mid + 1)) >> 1;

            // If sum is below N
            if (sum <= n) {

                // Find number of complete turns
                count = mid / k;

                // Right halve
                low = mid + 1;
            } else {

                // Left halve
                high = mid - 1;
            }
        }
        System.out.println("loop:" + loop);
        // Last term of last complete series
        int last = (count * k);

        // Subtract the sum till
        n -= (last * (last + 1)) / 2;

        int j = 0;

        // First term of incomplete series
        int term = (count * k) + 1;

        while (n > 0) {
            if (term <= n) {
                arr[j++] = term;
                n -= term;
                term++;
            } else {
                arr[j] += n;
                n = 0;
            }
        }

        // Count the total candies
        //n/2[2a + (n – 1)d]
        for (int i = 0; i < k; i++)
            arr[i] += (count * (i + 1)) + (k * (count * (count - 1)) / 2);

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    // candies every person received
    private static void candies3(int n, int k) {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
            arr[i] = 0;

        while (n > 0) {

            // Last term of last and current series
            int f1 = (ind - 1) * k;
            int f2 = ind * k;

            // Sum of current and last series
            int sum1 = (f1 * (f1 + 1)) / 2;
            int sum2 = (f2 * (f2 + 1)) / 2;

            // Sum of current series only
            int res = sum2 - sum1;

            // If sum of current is less than N
            if (res <= n) {
                count++;
                n -= res;
                ind++;
            } else {// Individually distribute
                int i = 0;

                // First term
                int term = ((ind - 1) * k) + 1;

                // Distribute candies till there
                while (n > 0) {

                    // Candies available
                    if (term <= n) {
                        arr[i++] = term;
                        n -= term;
                        term++;
                    } else // Not available
                    {
                        arr[i++] = n;
                        n = 0;
                    }
                }
            }
        }
        // Count the total candies
        for (int i = 0; i < k; i++) {
            arr[i] += (count * (i + 1)) + (k * (count * (count - 1)) / 2);
        }

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    private static void candies4(int n, int k) {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        int[] arr = new int[k];

        int a = 1;
        int d = 1;
        int loop = 0;
        while (n > 0) {
            loop++;
            // Sum of current series only
            // n/2[2a + (n – 1)d]
            int res = k * a + d * k * (k - 1) / 2;
            a += k;
            // If sum of current is less than N
            if (res <= n) {
                count++;
                n -= res;
                ind++;
            } else {// Individually distribute
                int i = 0;

                // First term
                int term = ((ind - 1) * k) + 1;

                // Distribute candies till there
                while (n > 0) {

                    // Candies available
                    if (term <= n) {
                        arr[i++] = term;
                        n -= term;
                        term++;
                    } else // Not available
                    {
                        arr[i++] = n;
                        n = 0;
                    }
                }
            }
        }
        System.out.println("loop:" + loop);
        // Count the total candies
        for (int i = 0; i < k; i++) {
            arr[i] += (count * (i + 1)) + (k * (count * (count - 1)) / 2);
        }

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }
}
// Driver Code