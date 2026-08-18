package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class DishTesting {

    public static void main(String[] args) {
        List<Dish> menu = Dish.getDishes();
        menu.sort(comparing(Dish::getCalories));
        printDishes(menu);
        menu.stream().filter(d -> d.getCalories() > 300).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(toList()).forEach(System.out::println);
        Map<Dish.Type, List<Dish>> data = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(data);
        List<String> ss = menu.stream().filter(d -> {
            System.out.println("Filtering " + d.getName());
            return d.getCalories() > 300;
        }).map((Dish d) -> {
            System.out.println("Mapping " + d.getName());
            return d.getName();
        }).limit(2).collect(toList());
        System.out.println(ss);

    }

    public static void printDishes(List<Dish> dishes) {
        for (Dish d : dishes) {
            System.out.print(d.getName() + " - " + d.getType() + " - " + d.getCalories() + ", ## ");
        }
        System.out.println();
    }

}
