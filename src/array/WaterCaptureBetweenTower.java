package array;

import java.util.Scanner;

public class WaterCaptureBetweenTower {

    public static void main(String[] args) {
        int M = 4; // No of Tower
        int N = 4; // Tower height
        String[] arr = new String[M];
        arr[0] = "-**-";
        arr[1] = "*---";
        arr[2] = "*-**";
        arr[3] = "*--*";
        for (String s : arr) {
            System.out.println(s);
        }
        int vol = volume_trapped(M, N, arr);
        System.out.println(vol);
    }

    public static int volume_trapped(int M, int N, String[] arr) {
        int result = 0;
        for (String s : arr) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!(i == 0 || i == chars.length - 1)) {
                    if (chars[i] == '-') {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
}
