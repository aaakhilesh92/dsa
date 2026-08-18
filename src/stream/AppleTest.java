package stream;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple(200, "blue"));
        inventory.add(new Apple(140, "green"));
        inventory.add(new Apple(100, "blue"));
        inventory.add(new Apple(160, "green"));
        inventory.add(new Apple(175, "green"));
        System.out.println("ALL Apples");
        inventory.forEach(a -> System.out.print(a + " ; "));
        System.out.println();
        List<Apple> greenApple = filterApples(inventory, a -> "green".equals(a.getColor()));
        List<Apple> blueApple = filterApples(inventory, a -> "blue".equals(a.getColor()));
        List<Apple> greenAndHeavyApple = filterApples(inventory, a -> "green".equals(a.getColor()) && a.getWeight() > 150);
        System.out.println("Green Apples");
        greenApple.forEach(a -> System.out.print(a + " ; "));
        System.out.println();
        System.out.println("blue Apples");
        blueApple.forEach(a -> System.out.print(a + " ; "));
        System.out.println();
        System.out.println("green and heavy Apples");
        greenAndHeavyApple.forEach(a -> System.out.print(a + " ; "));
        System.out.println();
    }

    public static <T> List<T> filterApples(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : inventory) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
