package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingByFrequency {

    public static void main(String[] args) {
        // Declare and Initialize an array
        int[] array = { 4, 4, 2, 2, 2, 2, 6, 1, 6, 3, 1, 3, 6, 7, 5 };
        printArray(array);
        array = sorting2(array);
        printArray(array);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for (T x : list) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public static int[] sorting(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            list.add(x);
        }

        Comparator<Integer> cmp = (i1, i2) -> {
            int freqCompare = map.get(i2).compareTo(map.get(i1));
            if (freqCompare == 0) {
                return i1.compareTo(i2);
            } else {
                return freqCompare;
            }

        };
        list.sort(cmp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int[] sorting2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> insertionOrderMap = new HashMap<>();
        int insertOrder = 1;
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            Integer cc = insertionOrderMap.get(key);
            if (cc == null) {
                insertionOrderMap.put(key, insertOrder++);
            }
        }
        System.out.println(insertionOrderMap);

        List<Integer> list = new ArrayList<>(map.keySet());

        Comparator<Integer> cmp = (i1, i2) -> {
            int freqCompare = map.get(i2).compareTo(map.get(i1));
            if (freqCompare == 0) {
                freqCompare = insertionOrderMap.get(i1).compareTo(insertionOrderMap.get(i2));
            }
            return freqCompare;
        };
        list.sort(cmp);
        int j = 0;
        for (int x : list) {
            int frequency = map.get(x);
            for (int i = 0; i < frequency; i++)
                arr[j++] = x;
        }
        return arr;
    }
}
