package array;

import java.util.Stack;

public class StudentCourse {
    public static void main(String[] args) {
        String str1 = "(()(()))";
        String str2 = "()()";
        String str3 = "()";
        System.out.println(getCount(str1));
    }

    public static int getCount(String str) {
        int result = 0;
        Stack<String> st = new Stack<>();

        for (int i = 0; i < str.length();) {
            if (str.charAt(i) == '(') {
                st.push(String.valueOf(str.charAt(i)));
                i++;
            } else {
                String s = st.peek();
                if (s.equals("(")) {
                    st.pop();
                    st.push("1");
                    i++;
                } else {
                    // "(()(()))";
                    int num = Integer.parseInt(st.pop());
                    String t = st.peek();
                    while (!t.equals("(")) {
                        num += Integer.parseInt(st.pop());
                        t = st.peek();
                    }
                    st.pop();
                    num = 2 * num;
                    st.push(String.valueOf(num));
                    i++;
                    // result = num;
                }
            }
        }
        while (!st.empty()) {
            result += Integer.parseInt(st.pop());
        }
        return result;
    }
}
