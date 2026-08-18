package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Comparator;

public class MaxTesting {

    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();
        names.put("Anne", 10);
        names.put("John", 25);
        names.put("Bob", 2);
        Set<Entry<String, Integer>> set = names.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort(list, (e1, e2) -> (e2.getValue()).compareTo(e1.getValue()));
        for (Entry<String, Integer> e : list) {
            System.out.print(e + ", ");
        }
        System.out.println();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(7);
        list1.add(4);
        list1.add(10);
        list1.add(3);
        list1.add(17);
        Stream<Integer> myStream = list1.stream();
        Stream<Integer> myVals = list1.stream().sorted().filter(n -> n % 2 == 1);
        list1.stream().filter(n -> n % 2 == 1).filter(n -> n > 5).forEach(n -> System.out.print(n + " "));
        String[] arr = "Akhilesh Akhiles Akhile Priti Pritii".split(" ");
        Optional<String> res = Arrays.stream(arr).filter(s -> s.length() % 2 == 0).max(Comparator.comparingInt(s -> s.length()));
        System.out.println(res.orElse("aaa"));
    }
}