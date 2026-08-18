package datastructure;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Testing {
    public static void main(String[] args) {
        Set<Integer> q = new HashSet<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.contains(q);

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

// Parent - method1 SSLException
// child - method1 - same checked or exception, complete remove, cannot IOException