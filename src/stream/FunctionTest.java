package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        List<String> slist = Arrays.asList("Akhilesh", "Somesh", "Rashmi", "Uma", "Donjo");
        List<Integer> ss = map(slist, t -> t.length());
        ss.forEach(System.out::println);
        
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

}
