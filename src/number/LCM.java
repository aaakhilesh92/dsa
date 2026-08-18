package number;
import java.util.Vector;
public class LCM {

    public static long lcm_of_array_elements(int[] element_array) {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                } else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            } else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

    // Java program to find LCM of array without using GCD.

    // Returns LCM of arr[0..n-1]
    public static long lcm(int arr[]) {
        int n = arr.length;
        // Find the maximum value in arr[]
        int max_num = 0;
        for (int i = 0; i < n; i++) {
            if (max_num < arr[i]) {
                max_num = arr[i];
            }
        }

        // Initialize result
        long res = 1;

        // Find all factors that are present in
        // two or more array elements.
        int x = 2; // Current factor.
        while (x <= max_num) {
            // To store indexes of all array
            // elements that are divisible by x.
            Vector<Integer> indexes = new Vector<>();
            for (int j = 0; j < n; j++) {
                if (arr[j] % x == 0) {
                    indexes.add(indexes.size(), j);
                }
            }

            // If there are 2 or more array elements
            // that are divisible by x.
            if (indexes.size() >= 2) {
                // Reduce all array elements divisible
                // by x.
                for (int j = 0; j < indexes.size(); j++) {
                    arr[indexes.get(j)] = arr[indexes.get(j)] / x;
                }

                res = res * x;
            } else {
                x++;
            }
        }

        // Then multiply all reduced array elements
        for (int i = 0; i < n; i++) {
            res = res * arr[i];
        }

        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] element_array = {2, 3, 9, 4, 7};
        System.out.println(lcm(element_array));
    }
}
