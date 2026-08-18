package string;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string that is formed from only three characters ‘a’, ‘b’, ‘c’. 
 * You are allowed to change atmost ‘k’ characters in the given string while attempting to optimize the uniformity index.
 * Note : The uniformity index of a string is defined by the maximum length of the substring that contains same character in it.
 * Input : The first line of input contains two integers n (the size of string) and k. The next line contains a string of length n.
 * Output : A single integer denoting the maximum uniformity index that can be achieved.
 * Sample Input :
 * 6 3
 * abaccc
 * Sample Output - 6
 * Explanation - First 3 letters can be changed to ‘c’ and we can get the string ‘cccccc’
 */
public class UniformityIndex {

    public static void main(String[] args) {
        String s = "abaabcccc";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        freq(s);
    }

    public static void freq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);
    }

    public static int characterReplacement(String s, int k) {
        int maxi = 0;
        int ans = 0;
        int l = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0;
        for (; i < l; i++) {
            char ch = s.charAt(i);
            countMap.merge(ch, 1, Integer::sum);
            // countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            // if (!countMap.containsKey(ch)) {
            // countMap.put(ch, 1);
            // } else {
            // int c = countMap.get(ch);
            // countMap.put(ch, c + 1);
            // }
            maxi = Math.max(maxi, countMap.getOrDefault(ch, 0));

            if ((ans - maxi) < k) {
                ans += 1;
            } else {
                char ch2 = s.charAt(i - ans);
                int c = countMap.get(ch2);
                countMap.put(ch2, c - 1);
            }
        }
        return ans;
    }
}
