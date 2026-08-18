package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterTesting {

    public static void main(String[] args) {
        List<String> slist = Arrays.asList("Akhilesh", "Somesh", "Pratibha", "Uma", "Don");
        List<String> ss = filter(slist, s -> s.length() > 6);
        ss.forEach(System.out::println);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

}
