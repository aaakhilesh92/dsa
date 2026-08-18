package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerTest {

    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5, 6), i -> System.out.print(i + " "));
        List<Integer> sizes = map(Arrays.asList("Akhilesh", "Priti"), t -> t.length());
        System.out.println();
        System.out.println(sizes);
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> resList = new ArrayList<R>();
        for (T s : list) {
            resList.add(function.apply(s));
        }
        return resList;
    }

}
