package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBadLegacy {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(4);
        myList.add(6);
        Inserter in = new Inserter();
        in.insert(myList); // pass List<Integer> to legacy code
        Iterator it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}

class Inserter {
// method with a non-generic List argument
    void insert(List list) {
        list.add(new Integer(42)); // adds to the incoming list
        list.add(new String("42"));
    }
}