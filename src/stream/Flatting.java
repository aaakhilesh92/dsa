package stream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Flatting {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Akhilesh", "Priti");
        List<String> ss = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
                .collect(toList());
        for (String s : ss) {
            System.out.println(s);
        }
    }

}
