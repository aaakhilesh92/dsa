package other;

import java.util.Scanner;

public class problemB {
    static int change(String s) {
        int n = s.length();
        int result = n / 2;
        int t = result / 2;
        for (int i = 0; i <= t; i++) {
            int temp = changesAfterInsertion(s, i);
            if (temp < result) {
                result = temp;
            }
        }
        return result;
    }

    static int changesAfterInsertion(String s, int c) {
        StringBuilder sb = new StringBuilder();
        if (c > 0) {
            for (int i = c - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        }
        s = s.concat(sb.toString());
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                continue;
            }
            count += 1;
        }

        return count + c;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = "abcdefgfeac";
        int count = change2((s));
        System.out.println(count);
    }

    static int judge(int i, int j, String str) {
        int cnt = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j - 1)) {
                cnt++;
            }
            i++;
            j--;
        }
        return cnt;
    }

    static int change2(String s) {
        int MIN = 0;
        int len = s.length();
        int size = len / 2;
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = i + judge(i, len, s);
        }
        MIN = num[0];
        for (int i = 1; i < size; i++) {
            MIN = Math.min(MIN, num[i]);
        }

        return MIN;
    }
}