package number;

import java.util.TreeMap;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        int num = 49;
        System.out.println("Number " + num + " prime?: " + isPrime(num));
        num = 7;
        System.out.println("Number " + num + " prime?: " + isPrime(num));
        num = 18;
        // System.out.println("Number " + num + " prime?: " + isPrime2(num));
        // TreeMap<Integer, String> ll = new TreeMap<>();

        // ll.put(12, "");
        // ll.put(13, "");
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num; i = i + 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        // return true;
        int sqrt = (int) (Math.sqrt(num));
        boolean isPrime = true;
        for (int x = 2; x <= sqrt; x++) {
            if (num % x == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Number is not prime");
        }
        return isPrime;
    }

    private static boolean isPrime2(int number) {
        IntPredicate isDivisible = input -> number % input == 0;
        int sqrt = (int) (Math.sqrt(number));
        return number > 1 && IntStream.rangeClosed(2, sqrt).noneMatch(isDivisible);
    }
}
