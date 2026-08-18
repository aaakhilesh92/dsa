package datastructure;

import java.util.Stack;

public class StackUsingQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enQueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue an item from the queue
    public int deQueue() {
        // if first stack is empty
        if (s1.isEmpty()) {
            System.out.println("Q is Empty");
            return -1;
        }

        // Return top of s1
        return s1.pop();
    }

    public void enQueue2(int x) {
        s1.push(x);
    }

    /* Function to deQueue an item from queue */
    public int deQueue2() {
        int x;

        /* If both stacks are empty then error */
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Q is empty");
            return -1;
        }

        // Move elements from stack1 to stack 2 only if stack2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(x = s1.pop());
            }
        }
        x = s2.pop();
        return x;
    }

    public static void main(String[] args) {
        StackUsingQueue q = new StackUsingQueue();
        q.enQueue2(1);
        q.enQueue2(2);
        q.enQueue2(3);

        System.out.println(q.deQueue2());
        System.out.println(q.deQueue2());
        System.out.println(q.deQueue2());
    }
}
