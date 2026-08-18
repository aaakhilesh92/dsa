package number;

import java.util.Random;

public class RandomNumberTest {

    public static void main(String[] args) {
        Random random = new Random();
        random.ints(5, 100, 200).forEach(s -> System.out.print(s + ", "));
    }

}
