package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OddNumberFrequency {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(3);
        list.add(9);
        Map<Integer, Long> freq = findOddNumberFrequency(list);
    }

    public static Map<Integer, Long> findOddNumberFrequency(List<Integer> list) {
        Map<Integer, Long> map = list.stream().filter(n -> n % 2 == 1).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        System.out.println("Odd Numbers Frequency: " + map);
        return map;
    }

}
