package other;

import java.util.stream.Stream;

public class NameCreate {

    public static void main(String[] args) {
        String str = "Longest sub-array having sum k";
        str = str.replaceAll("[-_]", " ");
        String name = Stream.of(str.split(" ")).map(s -> s.toLowerCase().replaceFirst("[a-z]", String.valueOf(Character.toUpperCase(s.charAt(0))))).reduce("", (s1, s2) -> s1 + s2);
        System.out.println(name);
    }
}
