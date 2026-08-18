package stream;

import java.util.Arrays;

public class ReducingTest {

    public static void main(String[] args) {
        int sum = Arrays.asList(1, 2, 3, 4, 6, 5).stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum:" + sum);
        int max = Arrays.asList(1, 2, 3, 4, 6, 5).stream().reduce(0, Integer::max);
        System.out.println("max:" + max);
        long count = Dish.getDishes().stream().count();
        System.out.println("count:" + count);
        int count2 = Dish.getDishes().stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("count2:" + count2);
    }

}
