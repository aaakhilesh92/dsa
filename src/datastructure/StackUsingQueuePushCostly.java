package datastructure;

/* Java Program to implement a stack using two queue */
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuePushCostly {
    private static class Stack {
        // Two inbuilt queues
        static Queue<Integer> queue1 = new LinkedList<Integer>();
        static Queue<Integer> queue2 = new LinkedList<Integer>();

        // To maintain current number of elements
        static int curr_size;

        Stack() {
            curr_size = 0;
        }

        public void push(int x) {
            curr_size++;

            // Push x first in empty q2
            queue2.add(x);

            // Push all the remaining elements in q1 to q2.
            while (!queue1.isEmpty()) {
                queue2.add(queue1.peek());
                queue1.remove();
            }

            // Swap the names of two queues
            Queue<Integer> q = queue1;
            queue1 = queue2;
            queue2 = q;
        }

        public int pop() {
            // if no elements are there in q1
            if (queue1.isEmpty()) {
                return -1;
            }

            int item = queue1.remove();
            curr_size--;
            return item;
        }

        public int top() {
            if (queue1.isEmpty())
                return -1;
            return queue1.peek();
        }

        public int size() {
            return curr_size;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}
