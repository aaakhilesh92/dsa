package array;

public class FrequencyInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 3, 3, 3, 4};
        int x = 4;
        System.out.println("Frequency of num " + x + ": " + getFreq(x, arr));
        System.out.println("Frequency of num " + x + ": " + count(arr, x));
    }
    public static int getFreq(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int freq = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n == arr[mid]) {
                freq++;
                int l = mid - 1;
                while (l >= 0 && n == arr[l]) {
                    freq++;
                    l--;
                }
                int h = mid + 1;
                while (h < arr.length && n == arr[h]) {
                    freq++;
                    h++;
                }
                break;
            } else if (n < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return freq;
    }

    // if x is present in arr[] then returns the count of occurrences of x, otherwise returns -1.
    static int count(int arr[], int x) {
        // index of first occurrence of x in arr[0..n-1]
        int i;

        // index of last occurrence of x in arr[0..n-1]
        int j;
        int n = arr.length;
        /* get the index of first occurrence of x */
        // i = first(arr, 0, n - 1, x, n);
        i = findFirst(arr, 0, n - 1, x, n);

        /* If x doesn't exist in arr[] then return -1 */
        if (i == -1)
            return i;

        /*
         * Else get the index of last occurrence of x. Note that we are only looking in the subarray after
         * first occurrence
         */
        // j = last(arr, i, n - 1, x, n);
        j = findLast(arr, i, n - 1, x, n);
        /* return count */
        return j - i + 1;
    }

    // if x is present in arr[] then returns the index of FIRST occurrence of x in arr[0..n-1],
    // otherwise returns -1
    static int first(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }
    /*
     * if x is present in arr[] then returns the index of LAST occurrence of x in arr[0..n-1], otherwise
     * returns -1
     */
    static int last(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }
    static int findFirst(int arr[], int low, int high, int x, int n) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                result = mid;
                break;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int findLast(int arr[], int low, int high, int x, int n) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x) {
                result = mid;
                break;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
