package datastructure;

import java.util.Stack;

public class QueueUsingStackEnQueueCostly {
    private static class Queue {
        private Stack<Integer> stack1 = new Stack<Integer>();
        private Stack<Integer> stack2 = new Stack<Integer>();

        public void enQueue(int x) {
            // Move all elements from s1 to s2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            // Push item into s1
            stack1.push(x);

            // Push everything back to s1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        // Dequeue an item from the queue
        public int deQueue() {
            // if first stack is empty
            if (stack1.isEmpty()) {
                System.out.println("Q is Empty");
                return -1;
            }

            // Return top of s1
            int x = stack1.pop();
            return x;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}