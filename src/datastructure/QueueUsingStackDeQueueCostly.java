package datastructure;

import java.util.Stack;

public class QueueUsingStackDeQueueCostly {
    /* class of queue having two stacks */
    private static class Queue {
        private Stack<Integer> stack1 = new Stack<Integer>();
        private Stack<Integer> stack2 = new Stack<Integer>();

        /* Function to push an item to stack */
        public void enQueue(int x) {
            // Push the data onto the stack
            stack1.push(x);
        }

        /* Function to deQueue an item from queue */
        public int deQueue() {

            /* If both stacks are empty then error */
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            // Move elements from stack1 to stack 2 only if stack2 is empty
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    int x = stack1.pop();
                    stack2.push(x);
                }
            }
            int x = stack2.pop();
            return x;
        }
    }

    /* Driver function to test above functions */
    public static void main(String args[]) {
        /* Create a queue with items 1 2 3 */
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        System.out.println(q.deQueue());
        q.enQueue(3);

        /* Dequeue items */
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
