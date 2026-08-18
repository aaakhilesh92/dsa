package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeAndCompositeNum {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 8, 2, 6 };
        int[] out_ = PrimeAndComposite(arr.length, arr);
        for (int i = 0; i < out_.length; i++) {
            System.out.print(out_[i] + " ");
        }

    }

    static int[] PrimeAndComposite(int N, int[] numbers) {
        List<Integer> primeNum = new ArrayList<>();
        List<Integer> compositeNum = new ArrayList<>();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = -1;
        }
        List<Integer> list = new ArrayList<>();
        int k = 0;
        for (int x : numbers) {
            if (isPrime(x)) {
                primeNum.add(x);
                list.add(k);
            } else {
                compositeNum.add(x);
            }
            k++;
        }
        Collections.sort(primeNum);
        Collections.sort(compositeNum, Collections.reverseOrder());
        int i = 0;
        int index1 = 0;
        int index2 = 0;

        while (i < N) {
            if (index1 < list.size() && i == list.get(index1)) {
                result[i] = primeNum.get(index1);
                index1++;
            } else {
                result[i] = compositeNum.get(index2);
                index2++;
            }
            i++;
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return true;
        }
        int limit = ((int) Math.sqrt(num));
        return IntStream.rangeClosed(2, limit).noneMatch(i -> num % i == 0);
    }
}