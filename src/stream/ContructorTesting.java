package stream;

import static java.util.Comparator.comparing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ContructorTesting {
    static Map<String, Function<Integer, Apple>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
    }

    public static void main(String[] args) {
        BiFunction<Integer, String, Apple> s1 = Apple::new;
        Apple a = s1.apply(100, "Red");
        System.out.println(a);
        System.out.println(giveMeApple("apple", 120));
        List<Apple> inv = Apple.getAppleInventory();
        System.out.println("Before Sorting");
        inv.forEach(System.out::println);
        inv.sort(comparing(Apple::getWeight));
        System.out.println("After Sorting");
        inv.forEach(System.out::println);
    }

    public static Apple giveMeApple(String key, Integer weight) {
        return map.get(key).apply(weight);
    }

}
