package stream;

import java.util.Arrays;

public class SecondHighestNumberStream {
    private static int[] array = { 545, 23, 92, 1, 200, 532 };

    public static void main(String[] args) {
        int n = 3;
        System.out.print(n + "th biggest number in array is: ");
        Arrays.stream(array).sorted().limit(array.length - n + 1).skip(array.length - n).forEach(System.out::println);
    }
}
