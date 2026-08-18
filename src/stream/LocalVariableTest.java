package stream;

import java.util.function.Function;

public class LocalVariableTest {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int val = 4;
        int x = h.apply(val);
        System.out.println(x);
        Function<Integer, Integer> i = f.compose(g);
        int y = i.apply(val);
        System.out.println(y);
    }
}
