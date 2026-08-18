package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoining {
    public static void main(String[] args) {
        List<String> awesomeAnimals = Arrays.asList("Shark", "Panda", "Armadillo");
        String animalString = awesomeAnimals.stream().collect(Collectors.joining(", "));
        System.out.println(animalString);
    }
}
