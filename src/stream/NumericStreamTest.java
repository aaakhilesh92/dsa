package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamTest {

    public static void main(String[] args) {
        System.out.println("sum : " + Dish.getDishes().stream().map(Dish::getCalories).reduce(0, Integer::sum));
        System.out.println("sum : " + Dish.getDishes().stream().mapToInt(Dish::getCalories).sum());
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0]).forEach(t -> System.out.println(t));
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

}
