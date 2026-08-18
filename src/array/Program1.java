package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program1 {
    public static void main(String[] args) {
        String[][] arr = {{"course4", "course5"}, {"course2", "course3"}, {"course5", "course6"}, {"course3", "course4"}, {"course6", "course7"},
                {"course7", "course8"}, {"course8", "course9"}, {"course1", "course2"}, {"course9", "course10"}};
        find(arr);

    }

    public static String find(String[][] arr) {
        System.out.println(arr.length);
        Map<String, String> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        for (String[] pair : arr) {
            map.put(pair[0], pair[1]);
            set1.add(pair[1]);
        }
        String first = null;
        for (String s : map.keySet()) {
            if (!set1.contains(s)) {
                first = s;
                break;
            }
        }
        int i = 1;
        int n = (arr.length + 1) / 2;
        while (i < n) {
            String str = map.get(first);
            System.out.print(first + "->");
            first = str;
            i++;
        }
        System.out.println();
        System.out.println(first);
        return null;
    }
}
