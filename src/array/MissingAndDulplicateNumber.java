package array;

public class MissingAndDulplicateNumber {
    public static void main(String[] args) {

    }

    // Given an array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times.
    // Find these repeating numbers in O(n) and using only constant memory space.
    public static void printRepeating(int arr[]) {
        int size = arr.length;
        System.out.println("The repeating elements are : ");

        for (int i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                System.out.print(j + " ");
            }
        }
    }

    // Print missing and Duplicate Number
    public static void printTwoElements(int arr[], int size) {
        int i;
        System.out.print("The repeating element is ");

        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }

        System.out.print("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }

    static void getTwoElements2(int arr[], int n) {
        // Will hold xor of all elements and numbers from 1 to n
        int xor1;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        int x = 0;
        int y = 0;

        xor1 = arr[0];

        /* Get the xor of all array elements */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];

        // XOR the previous result with numbers from 1 to n
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

        // Now divide elements into two sets by comparing rightmost set bit of xor1 with the bit at the same position in each element.
        // Also, get XORs of two sets. The two XORs are the output elements. The following two for loops serve the purpose

        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0) {
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
            } else {
                /* arr[i] belongs to second set */
                y = y ^ arr[i];
            }
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0) {
                /* i belongs to first set */
                x = x ^ i;
            } else {
                /* i belongs to second set */
                y = y ^ i;
            }
        }

        /* *x and *y hold the desired output elements */
    }
}
