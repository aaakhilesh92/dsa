package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        process("aabbccc");
    }
    public static void process(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());
        char[] result = new char[str.length()];
        int i = 0;
        for (char c : list) {
            int count = map.get(c);
            for (int j = 0; j < count; j++) {
                result[i] = c;
                i++;
            }
        }
        for (char c : result) {
            System.out.print(c);
        }
    }
    public static void process2(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());
        Collections.sort(null, null);
        char[] result = new char[str.length()];
        int i = 0;
        for (char c : list) {
            int count = map.get(c);
            for (int j = 0; j < count; j++) {
                result[i] = c;
                i++;
            }
        }
        for (char c : result) {
            System.out.print(c);
        }
    }
}
