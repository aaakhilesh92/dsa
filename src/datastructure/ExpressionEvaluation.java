package datastructure;

import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionEvaluation {
    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+' :
            case '-' :
                return 1;

            case '*' :
            case '/' :
                return 2;

            case '^' :
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression to postfix expression.
    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length();) {
            char ch = exp.charAt(i);
            String str = "";
            while (i < exp.length() && Character.isDigit(ch = exp.charAt(i))) {
                i++;
                str += ch;
            }

            // If the scanned character is an operand, add it to output.
            if (!"".equals(str)) {
                result += str + "_";
                i--;
            }
            // "2+4*(6-3)-(12/4+1*3)-6";
            // If the scanned character is an '(', push it to the stack.
            else if (ch == '(')
                stack.push(ch);

            // If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop() + "_";

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())) {

                    result += stack.pop() + "_";
                }
                stack.push(ch);
            }
            i++;
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop() + "_";
        }
        return result;
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "2+4*(60-30)-(80/40+1*3)-60";
        String str = infixToPostfix(exp);
        Stack<Integer> st = new Stack<>();
        String[] arr = str.split("_");
        for (String s : arr) {
            if (isNumeric(s)) {
                st.push(Integer.parseInt(s));
            } else {
                int second = st.pop();
                int first = st.pop();
                switch (s) {
                    case "+" :
                        st.push(first + second);
                        break;
                    case "-" :
                        st.push(first - second);
                        break;
                    case "*" :
                        st.push(first * second);
                        break;
                    case "/" :
                        st.push(first / second);
                        break;
                }

            }
        }
        System.out.println(st.pop());
    }
    private static Pattern pattern = Pattern.compile("\\d+");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
