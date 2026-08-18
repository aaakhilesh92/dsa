package string;

//Java program to find length of the longest valid subString
public class Parenthesis {

    public static int findMaxLen(String s) {
        if (s.length() <= 1)
            return 0;

        int curMax = 0;
        int[] longest = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
            if (s.charAt(i) == ')') {
                int prevLength = longest[i - 1];
                int prevIndex = i - prevLength - 1;
                if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                    int prevIndex_2 = i - prevLength - 2;
                    int val = 0;
                    if (prevIndex_2 >= 0)
                        val = longest[prevIndex_2];

                    // int val = prevIndex_2 >= 0 ? longest[prevIndex_2] : 0;
                    longest[i] = prevLength + 2 + val;
                    // longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                    curMax = Math.max(longest[i], curMax);
                }
            }
        }

        return curMax;
    }

    // Length of longest balanced parentheses prefix
    public static int maxbalancedprefix(String str) {
        int n = str.length();
        int sum = 0;
        int maxi = 0;

        // Traversing the string.
        for (int i = 0; i < n; i++) {

            // If open bracket add 1 to sum.
            if (str.charAt(i) == '(')
                sum += 1;

            // If closed bracket subtract 1 from sum
            else
                sum -= 1;

            // if first bracket is closing bracket then this condition would help
            if (sum < 0)
                break;

            // If sum is 0, store the index value.
            if (sum == 0)
                maxi = i + 1;
        }

        return maxi;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "((()())())((";
        System.out.print(findMaxLen(str) + ",");
        System.out.print(maxbalancedprefix(str) + ",");
        System.out.println();

        str = "()(()))))";
        System.out.print(findMaxLen(str) + ",");
        System.out.print(maxbalancedprefix(str) + ",");
    }
}