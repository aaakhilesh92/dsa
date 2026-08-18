package datastructure;

/* Java Program to implement a stack using two queue */
import java.util.LinkedList;
import java.util.Queue;
public class QueueUsingStack {

    private static class Stack {
        // Two inbuilt queues
        private Queue<Integer> q1 = new LinkedList<Integer>();
        private Queue<Integer> q2 = new LinkedList<Integer>();

        public void push(int x) {
            // Push x first in empty q2
            q2.add(x);

            // Push all the remaining elements in q1 to q2.
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        public int pop() {
            // if no elements are there in q1
            if (q1.isEmpty())
                return -1;
            return q1.poll();
        }

        public int top() {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        public int pop2() {
            if (q1.isEmpty())
                return -1;

            // Leave one element in q1 and push others in q2.
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }

            // Pop the only left element from q1
            int topElement = q1.poll();

            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return topElement;
        }

        public void push2(int x) {
            q1.add(x);
        }

        public int top2() {
            if (q1.isEmpty())
                return -1;

            while (q1.size() != 1) {
                q2.add(q1.peek());
                q1.remove();
            }

            // last pushed element
            int temp = q1.peek();

            // to empty the auxiliary queue after
            // last operation
            q1.remove();

            // push last element to q2
            q2.add(temp);

            // swap the two queues names
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return temp;
        }

        public void push3(int x) {
            // Get previous size of queue
            int s = q1.size();

            // Push the current element
            q1.add(x);

            // Pop all the previous elements and put them after current element
            for (int i = 0; i < s; i++) {
                q1.add(q1.poll());
            }
        }

        public int pop3() {
            // if no elements are there in q1
            if (q1.isEmpty())
                return -1;
            return q1.poll();
        }

        public int size() {
            return q1.size();
        }
    }

    // driver code
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push3(1);
        s.push3(2);
        s.push3(3);
        s.push3(4);

        System.out.println("current size: " + s.size());
        System.out.println(s.pop3());
        System.out.println(s.pop3());
        System.out.println(s.pop3());
        System.out.println(s.pop3());

        System.out.println("current size: " + s.size());
    }
}
