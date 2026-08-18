package stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.IntSummaryStatistics;

public class ReducingTesting {

    public static void main(String[] args) {
        long count = Dish.getDishes().stream().collect(counting());
        System.out.println("count : " + count);
        Dish.getDishes().stream().max(comparing(Dish::getCalories)).ifPresent(System.out::println);
        Dish.getDishes().stream().collect(maxBy(comparingInt(Dish::getCalories))).ifPresent(System.out::println);
        long sum = Dish.getDishes().stream().collect(summingInt(Dish::getCalories));
        System.out.println("sum : " + sum);
        double avg = Dish.getDishes().stream().collect(averagingInt(Dish::getCalories));
        System.out.println("avg : " + avg);
        IntSummaryStatistics summary = Dish.getDishes().stream().collect(summarizingInt((Dish::getCalories)));
        System.out.println(summary);
        System.out.println(Dish.getDishes().stream().map(Dish::getName).collect(joining(", ")));
        int totalCalories = Dish.getDishes().stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories : " + totalCalories);
    }

}
