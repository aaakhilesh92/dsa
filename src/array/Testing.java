package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testing {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("SMS");
        list.add("OTP");
        list.add("Autoread");
        System.out.println(list);
        process(list);
        System.out.println(list);

    }
    public static void process(List<String> args) {
        Iterator<String> itr = args.iterator();
        while (itr.hasNext()) {
            if (!itr.next().equals("OTP")) {
                itr.remove();
            }
        }
    }
}
