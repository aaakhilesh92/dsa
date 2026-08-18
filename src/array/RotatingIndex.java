package array;

public class RotatingIndex {
    // Returns count of rotations for an array which is first sorted in ascending order, then rotated
    public static int countRotations(int arr[]) {
        return countRotationsRec(arr, 0, arr.length - 1);
    }
    public static int countRotationsRec(int arr[], int low, int high) {
        // This condition is needed to handle the case when array is not rotated
        // at all {30, 40, 50, 60, -- 70, -- 80, 90, 10, 20, 30};
        if (high < low)
            return 0;

        // If there is only one element left
        if (high == low)
            return low;

        // Find mid (low + high)/2;
        int mid = low + (high - low) / 2;

        // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
        int arr_mid_plus = arr[mid + 1];
        int arr_mid = arr[mid];
        int arr_mid_minus = arr[mid - 1];
        if (mid < high && arr[mid + 1] < arr[mid])
            return (mid + 1);

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid;
        int arr_high = arr[high];
        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return countRotationsRec(arr, low, mid - 1);

        return countRotationsRec(arr, mid + 1, high);
    }

    public static int countRotationIterative(int arr[]) {
        int high = arr.length - 1;
        int low = 0;
        int result = 0;
        while (low <= high) {
            // This condition is needed to handle the case when array is not rotated
            // at all {30, 40, 50, 60, -- 70, -- 80, 90, 10, 20, 30};
            if (high < low) {
                break;
            }
            // If there is only one element left
            if (high == low) {
                result = low;
                break;
            }
            int mid = low + (high - low) / 2;

            // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
            int arr_mid_plus = arr[mid + 1];
            int arr_mid = arr[mid];
            int arr_mid_minus = arr[mid - 1];

            if (mid < high && arr[mid + 1] < arr[mid]) {
                result = mid + 1;
                break;
            }

            // Check if mid itself is minimum element
            if (mid > low && arr[mid] < arr[mid - 1]) {
                result = mid;
                break;
            }
            int arr_high = arr[high];

            // Decide whether we need to go to left half or right half
            if (arr[high] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {40, 50, 60, 70, 80, 90, 100, 10, 20, 30};
        int n = arr.length;

        System.out.println(countRotations(arr));
        System.out.println(countRotationIterative(arr));
    }
}
