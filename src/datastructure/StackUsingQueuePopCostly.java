package datastructure;

/* Java Program to implement a stack using two queue */
import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQueuePopCostly {
    private static class Stack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int curr_size;

        public Stack() {
            curr_size = 0;
        }

        public void push(int x) {
            queue1.add(x);
            curr_size++;
        }

        public int pop() {
            if (queue1.isEmpty())
                return -1;

            // Leave one element in q1 and push others in q2.
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }

            // Pop the only left element from q1
            int item = queue1.remove();
            curr_size--;

            // swap the names of two queues
            Queue<Integer> q = queue1;
            queue1 = queue2;
            queue2 = q;
            return item;
        }

        public int top() {
            if (queue1.isEmpty())
                return -1;

            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }

            // last pushed element
            int temp = queue1.remove();

            // push last element to q2
            queue2.add(temp);

            // swap the two queues names
            Queue<Integer> q = queue1;
            queue1 = queue2;
            queue2 = q;
            return temp;
        }

        int size() {
            return curr_size;
        }
    }
    // Driver code
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }
}