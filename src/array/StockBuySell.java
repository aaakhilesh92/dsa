package array;
import java.util.ArrayList;
public class StockBuySell {

    public static void main(String[] args) {
        int[] arr = {20, 18, 19, 24, 16, 17, 15, 18, 25};
        System.out.println(maxProfitOneTime(arr));
        int[] arr1 = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit2(arr1));
        System.out.println(maxTwoBuySell(arr, arr.length));
        System.out.println(maxProfitKTimes(arr, arr.length, 4));
    }
    public static int maxProfitOneTime(int[] arr) {
        int minSoFar = arr[0];
        int profit = 0;
        for (int x : arr) {
            minSoFar = Math.min(minSoFar, x);
            profit = Math.max(x - minSoFar, profit);
        }
        return profit;
    }

    // Function to find out maximum profit by buying & selling a share atmost k times given stock price
    // of n days
    static int maxProfitKTimes(int[] price, int n, int k) {

        // table to store results of subproblems profit[t][i] stores maximum profit using atmost t
        // transactions up to day i (including day i)
        int[][] profit = new int[k + 1][n + 1];

        // For day 0, you can't earn money irrespective of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any transaction (i.e. k =0)
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in bottom-up fashion
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max_so_far = 0;
                for (int m = 0; m < j; m++) {
                    max_so_far = Math.max(max_so_far, price[j] - price[m] + profit[i - 1][m]);
                }
                profit[i][j] = Math.max(profit[i][j - 1], max_so_far);
            }
        }

        return profit[k][n - 1];
    }

    static int maxTwoBuySell(int arr[], int size) {
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;

        for (int i = 0; i < size; i++) {
            first_buy = Math.max(first_buy, -arr[i]);
            first_sell = Math.max(first_sell, first_buy + arr[i]);
            second_buy = Math.max(second_buy, first_sell - arr[i]);
            second_sell = Math.max(second_sell, second_buy + arr[i]);
        }
        return second_sell;
    }
    public static int maxProfit(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit = profit + arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
    public static int maxProfit2(int price[]) {
        int n = price.length;
        // Prices must be given for at least two days
        if (n == 1)
            return 0;

        int count = 0;
        int result = 0;
        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima

            // Find Local Maxima. Note that the limit is (n-1) as we are comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0) {
            System.out.println("There is no day when buying the stock " + "will make profit");
        } else {
            for (int j = 0; j < count; j++) {
                System.out.println("Buy on day: " + sol.get(j).buy + "  " + "Sell on day : " + sol.get(j).sell);
                result = result + price[sol.get(j).sell] - price[sol.get(j).buy];
            }
        }

        return result;
    }
}
class Interval {
    int buy, sell;
}
