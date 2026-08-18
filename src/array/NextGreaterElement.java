package array;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1, 5, 4 };
        printNGE(arr);
    }

    public static void printNGE(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        /*
         * if stack is not empty, then pop an element from stack.
         * If the popped element is smaller than next, then a) print the pair b) keep popping
         * while elements are smaller and stack is not empty
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            int next = -1;
            int element = arr[i];
            while (!s.empty() && (next = s.peek()) <= arr[i]) {
                s.pop();
            }

            nge[i] = s.empty() ? -1 : next;
            s.push(element);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " --> " + nge[i]);
    }

    public static void printNGE2(int[] arr) {
        int n = arr.length;
        MyStack st = new MyStack(n);
        int element, next;
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            next = arr[i];
            if (!st.isEmpty()) {
                element = st.pop();
                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (st.isEmpty())
                        break;
                    element = st.pop();
                }
                if (element > next)
                    st.push(element);
            }
            st.push(next);
        }
        while (!st.isEmpty()) {
            element = st.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    public static class MyStack {
        int top;
        int stack_size;
        int[] items;

        public MyStack(int n) {
            stack_size = n;
            items = new int[stack_size];
            top = -1;
        }

        public void push(int x) {
            if (top == stack_size - 1) {
                System.out.println("Stack is full");
            } else {
                items[++top] = x;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            } else {
                int element = items[top];
                items[top] = 0;
                top--;
                return element;
            }
        }

        public boolean isEmpty() {
            return (top == -1) ? true : false;
        }
    }
}
