package array;

import java.util.Arrays;

public class StationPlatformRequired {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 960, 1120, 1130, 1900, 2000};
        System.out.println("Minimum Number of Platforms Required = " + findStationRequired(arr, dep));
    }

    public static int findStationRequired(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        int n = arr.length;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }
}
