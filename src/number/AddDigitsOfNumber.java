package number;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AddDigitsOfNumber {

    public static void main(String[] args) {
        // 225
        List<Integer> list1 = new LinkedList<>();
        list1.add(5);
        list1.add(2);
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        // 1375
        list2.add(5);
        list2.add(7);
        list2.add(3);
        list2.add(1);
        List<Integer> result = addDigits(list1, list2);
        for (Integer i : result) {
            System.out.print(i);
        }
    }

    public static List<Integer> addDigits(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new LinkedList<>();
        Iterator<Integer> itr1 = list1.iterator();
        Iterator<Integer> itr2 = list2.iterator();
        int carry = 0;
        while (itr1.hasNext() || itr2.hasNext()) {
            int digit1 = 0;
            int digit2 = 0;
            if (itr1.hasNext()) {
                digit1 = itr1.next();
            }
            if (itr2.hasNext()) {
                digit2 = itr2.next();
            }
            int digit = digit1 + digit2 + carry;
            carry = digit / 10;
            digit %= 10;
            result.add(digit);

        }
        if (carry > 0)
            result.add(carry);
        return result;
    }
}
