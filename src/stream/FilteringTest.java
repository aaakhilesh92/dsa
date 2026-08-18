package stream;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class FilteringTest {

    public static void main(String[] args) {
        Dish.getDishes().stream().filter(Dish::isVegetarian).forEach(System.out::println);
        List<Dish> res = Dish.getDishes().stream().filter(Dish::isVegetarian).collect(toList());
        IntStream.of(1, 2, 5, 7, 8, 12, 4, 6, 11, 14, 2, 8).filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        System.out.println(res);
        System.out.println();
        System.out.println("#########Limit testing###########");
        Dish.getDishes().stream().filter(Dish::isVegetarian).limit(2).forEach(System.out::println);
        Dish.getDishes().stream().filter(Dish::isVegetarian).skip(2).forEach(System.out::println);
    }
}
