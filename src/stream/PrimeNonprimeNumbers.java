package stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNonprimeNumbers {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> res = IntStream.rangeClosed(2, 50).boxed().collect(partitioningBy(i -> isPrime(i)));
        List<Integer> list = new ArrayList<Integer>();
        // list.removeIf(filter)
        Map<Boolean, Long> res2 = IntStream.rangeClosed(2, 50).boxed().collect(partitioningBy(i -> isPrime(i), counting()));
        System.out.println(res);
        System.out.println(res2);
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));

    }

    public static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        return IntStream.range(2, sqrt).noneMatch(i -> num % i == 0);
    }

    public static Map<Integer, Long> findOddNumberFrequency(List<Integer> list) {
        Map<Integer, Long> map = list.stream().filter(n -> n % 2 == 1).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        System.out.println("Odd Numbers Frequency: " + map);
        return map;
    }

}
