package other;

import java.util.Stack;

public class AddUsingStack {

    public static void main(String[] args) {
        int num1 = 5887;
        Stack<Integer> st1 = new Stack<Integer>();
        convert(num1, st1);
        int num2 = 213;
        Stack<Integer> st2 = new Stack<Integer>();
        convert(num2, st2);
        Stack<Integer> res = addStack(st1, st2);
        display(res);
        System.out.println("Actual:" + (num1 + num2));
    }
    public static void convert(int num, Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while (num > 0) {
            temp.push(num % 10);
            num /= 10;
        }
        while (!temp.empty()) {
            st.push(temp.pop());
        }
    }
    public static Stack<Integer> addStack(Stack<Integer> st1, Stack<Integer> st2) {
        Stack<Integer> result = new Stack<>();
        int sum = 0;
        int carry = 0;
        while (!st1.empty() && !st2.empty()) {
            sum = carry + st1.pop() + st2.pop();
            carry = sum / 10;
            result.push(sum % 10);
        }
        while (!st1.empty()) {
            sum = carry + st1.pop();
            carry = sum / 10;
            result.push(sum % 10);
        }
        while (!st2.empty()) {
            sum = carry + st2.pop();
            carry = sum / 10;
            result.push(sum % 10);
        }
        if (carry > 0) {
            result.push(sum % 10);
        }

        while (!result.isEmpty()) {
            st1.push(result.pop());
        }
        result = st1;
        return result;
    }
    public static void display(Stack<Integer> res) {
        String s = "";
        while (!res.isEmpty()) {
            s = String.valueOf(res.peek()) + s;
            res.pop();
        }

        System.out.print(s + "\n");
    }
}
