package stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class MappingTest {

    public static void main(String[] args) {
        List<String> dishNames = Dish.getDishes().stream().map(Dish::getName).collect(toList());
        System.out.println(dishNames);
        List<Integer> dishLength = Dish.getDishes().stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(dishLength);
        String str[] = { "Hello", "World" };
        List<String> aa = Arrays.stream(str).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(aa);
        //////////////////////////////
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sq = nums.stream().map(n -> n * n).collect(toList());
        System.out.println("Square of numbers........");
        System.out.println(sq);
        System.out.println("##################################");
        List<Integer> arr1 = Arrays.asList(1, 2, 3);
        List<Integer> arr2 = Arrays.asList(3, 4);
        List<int[]> pair = arr1.stream().flatMap(i -> arr2.stream().map(j -> new int[] { i, j })).collect(toList());
        for (int[] aa1 : pair) {
            System.out.println(aa1[0] + "-" + aa1[1]);
        }
    }

}
