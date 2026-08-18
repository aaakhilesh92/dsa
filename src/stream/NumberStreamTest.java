package stream;

import java.util.Arrays;
import java.util.List;

public class NumberStreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        list.stream().mapToInt(Integer::intValue).filter(n -> n % 2 == 1).map(n -> n * n).forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println("sum : " + list.stream().mapToInt(Integer::intValue).filter(n -> n % 2 == 1).map(n -> n * n).sum());
    }

}
