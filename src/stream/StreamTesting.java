package stream;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Comparator.comparingInt;
import java.util.List;
import java.util.Optional;

class StreamTesting2 {

    public static void main(String[] args) {
        // "hackerearth".chars().distinct().peek(ch -> System.out.println(ch + "++")).sorted().forEach(ch -> System.out.println(ch + "**"));
        List<String> ss = new ArrayList<String>();
        String[] arr = "Akhilesh Akhiles Akhile Priti Pritii".split(" ");
        ss.add("Akhilesh");
        ss.add("Akhiles");
        ss.add("Akhile");
        ss.add("Priti");
        ss.add("Pritii");
        // arr.stream().filter(s->s.length()%2==0).max(Comparator.comparingInt(s->s.length())).ifPresent(System.out::println);
        Optional<String> res = Arrays.stream(arr).filter(s -> s.length() % 2 == 0).max(comparingInt(s -> s.length()));
        System.out.println(res.orElse("aaa"));
    }
}

public class StreamTesting extends StreamTesting2 {
}