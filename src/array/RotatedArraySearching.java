package array;
public class RotatedArraySearching {
    public static int search(int[] arr, int key) {
        return searchRec(arr, 0, arr.length - 1, key);
    }
    // Java program to search an element in sorted and rotated array using single pass of Binary Search
    // if key is present, otherwise returns -1
    public static int searchRec(int arr[], int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return mid;

        // If arr[low...mid] first subarray is sorted
        if (arr[low] <= arr[mid]) {
            // As this subarray is sorted, we can quickly check if key lies in half or other half

            if (key >= arr[low] && key <= arr[mid]) {
                return searchRec(arr, low, mid - 1, key);
            }

            // If key not lies in first half subarray, Divide other half into two subarrays
            // such that we can quickly check if key lies in other half
            return searchRec(arr, mid + 1, high, key);
        }

        // If arr[low..mid] first subarray is not sorted, then arr[mid... high] must be sorted subarray
        if (key >= arr[mid] && key <= arr[high]) {
            return searchRec(arr, mid + 1, high, key);
        }
        return searchRec(arr, low, mid - 1, key);
    }

    // Java program to search an element in sorted and rotated array using single pass of Binary Search
    // if key is present, otherwise returns -1
    public static int searchIterative(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        // if (low > high) return -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mid_i = arr[mid];
            if (arr[mid] == key) {
                result = mid;
                break;
            }

            // If arr[low...mid] first subarray is sorted
            if (arr[low] <= arr[mid]) {
                // As this subarray is sorted, we can quickly check if key lies in half or other half
                if (key >= arr[low] && key <= arr[mid]) {
                    high = mid - 1;
                } else {
                    // If key not lies in first half subarray, Divide other half into two subarrays,
                    // such that we can quickly check if key lies in other half
                    low = mid + 1;
                }
            } else {// If arr[low..mid] first subarray is not sorted, then arr[mid... high] must be sorted subarray
                if (key >= arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {40, 50, 60, 70, 80, 90, 100, 10, 20, 30};
        int key = 20;
        int i = searchIterative(arr, key);
        if (i != -1)
            System.out.println("Key " + key + " found at Index: " + i);
        else
            System.out.println("Key " + key + " not found");
    }
}
