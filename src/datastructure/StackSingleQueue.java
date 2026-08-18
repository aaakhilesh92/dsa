package datastructure;

//Java program to implement stack using a single queue
import java.util.LinkedList;
import java.util.Queue;

public class StackSingleQueue {
    Queue<Integer> q = new LinkedList<Integer>();

    // Push operation
    public void push(int val) {
        // get previous size of queue
        int size = q.size();

        // Add current element
        q.add(val);

        // Pop (or Dequeue) all previous elements and put them after current element
        for (int i = 0; i < size; i++) {
            // This will add front element into rear of queue
            int x = q.remove();
            q.add(x);
        }
    }

    // Removes the top element
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    // Returns top of stack
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    // Returns true if Stack is empty else false
    boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackSingleQueue s = new StackSingleQueue();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        System.out.println("Top element :" + s.pop());
    }
}