package array;

public class CountCoins {
    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int n, int value) {
        // table[i] will be storing the minimum number of coins required for i value. So table[value] will have result
        int table[] = new int[value + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= value; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all values from 1 to V
        for (int i = 1; i <= value; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < n; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
        }
        if (table[value] == Integer.MAX_VALUE)
            return -1;
        return table[value];
    }
    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int n = coins.length;
        int value = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, n, value));
    }
}
