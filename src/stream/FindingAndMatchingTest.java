package stream;

import java.util.Arrays;
import java.util.Optional;

public class FindingAndMatchingTest {

    public static void main(String[] args) {
        if (Dish.getDishes().stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is veg friendly");
        }
        if (Dish.getDishes().stream().allMatch(d -> d.getCalories() < 1000)) {
            System.out.println("The menu is healty");
        }

        if (Dish.getDishes().stream().noneMatch(d -> d.getCalories() >= 1000)) {
            System.out.println("The menu is healty");
        }
        Optional<Dish> d = Dish.getDishes().stream().filter(Dish::isVegetarian).findAny();
        d.ifPresent(System.out::println);
        Optional<Integer> sq = Arrays.asList(1, 2, 3, 6, 5).stream().map(n -> n * n).filter(i -> i % 3 == 0).findAny();
        sq.ifPresent(System.out::println);
    }

}
