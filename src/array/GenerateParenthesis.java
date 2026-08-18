package array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    // Function to generate all the combinations of balanced parenthesis
    static void generateParenthesis(int left, int right, String s, List<String> answer) {

        // terminate
        if (left == 0 && right == 0) {
            answer.add(s);
        }

        if (left > right || left < 0 || right < 0) {
            // wrong
            return;
        }

        s += "{";
        generateParenthesis(left - 1, right, s, answer);
        s = s.substring(0, s.length() - 1);

        s += "}";
        generateParenthesis(left, right - 1, s, answer);
        s = s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        int n = 3;

        // vector ans is created to store all the possible
        // valid combinations of the parentheses.
        List<String> ans = new ArrayList<>();
        String s = "";

        // initially we are passing the counts of open and close as 0, and the string s as an empty string.
        generateParenthesis(n, n, s, ans);

        // Now, here we print out all the combinations.
        for (String k : ans) {
            System.out.println(k);
        }
    }
}
