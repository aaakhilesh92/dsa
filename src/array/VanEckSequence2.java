package array;

// Java program to count the occurrence of nth term in first n terms of Van Eck's sequence
import java.util.HashMap;
import java.util.Map;

public class VanEckSequence2 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Van Eck Sequence upto " + n + " : " + vanEckSequence(n));
        n = 15;
        System.out.println("Van Eck Sequence upto " + n + " : " + vanEckSequence(n));
    }

    public static String vanEckSequence(int range) {
        int distance = 0;
        int nextNumber = 0;
        String sequence = "";
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < range; i++) {
            if (numberMap.containsKey(nextNumber)) {
                distance = i - numberMap.get(nextNumber);
            } else {
                distance = 0;
            }
            numberMap.put(nextNumber, i);
            sequence += nextNumber + ", ";
            nextNumber = distance;
        }
        return sequence;
    }
}
