package string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//JAVA program to find first non-repeating character
public class FirstNonRepeatingCharacter2 {

    // this function return the index of first non-repeating character if found, or else it returns -1
    public static int firstNonRepeating(String str) {
        int[] fi = new int[26]; // array to store First Index

        // initializing all elements to -1
        for (int i = 0; i < 26; i++)
            fi[i] = -1;

        // sets all repeating characters to -2 and non-repeating characters contain the index where they
        // occur
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            if (fi[index] == -1) {
                fi[index] = i;
            } else {
                fi[index] = -2;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            // If this character is not -1 or -2 then it means that this character occurred only once so find
            // the min index of all characters that occur only once, that's our first index
            if (fi[i] >= 0) {
                res = Math.min(res, fi[i]);
            }
        }

        // if res remains Integer.MAX_VALUE, it means there are no
        // characters that repeat only once or the string is empty
        if (res == Integer.MAX_VALUE)
            return -1;
        else
            return res;
    }
    // this function return the index of first non-repeating character if found, or else it returns -1
    public static void firstNonRepeating2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        Iterator<Character> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Character ch = itr.next();
            int count = map.get(ch);
            if (count == 1) {
                System.out.println("First non-repeating character is:" + ch);
                break;
            }
        }
    }
    
    public static void main(String args[]) {
        String str;
        str = "ynabcabcjlgm";
        // firstNonRepeating2(str);
        int firstIndex = firstNonRepeating(str);
        if (firstIndex == -1)
            System.out.println("Either all characters are repeating or string is empty");
        else
            System.out.println("First non-repeating character is " + str.charAt(firstIndex));
    }
}
