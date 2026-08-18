package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class NumberSummaryStatistics {
    private static int[] array = { 545, 23, 92, 1, 200, 532 };

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.stream(array).forEach(list::add);
        System.out.println("Sum of Number: " + list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Average of Number: " + list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println("Max of Number: " + list.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println("Min of Number: " + list.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println("Count of Number: " + list.stream().mapToInt(Integer::intValue).count());
        IntSummaryStatistics st = Arrays.stream(array).summaryStatistics();
        System.out.println("Count of Number: " + st.getCount() + ", Average of Number:" + st.getAverage() + " " + st.getSum() + " " + st.getMax());
        System.out.println("SummaryStatistics of Number: " + list.stream().mapToInt(Integer::intValue).summaryStatistics());
        System.out.println("Sum of Number" + Arrays.stream(array).sum());
    }
}
