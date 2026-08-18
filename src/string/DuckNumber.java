package string;

/*
 * A Duck number is a positive number which has zeroes present in it, For example 3210, 8050896, 70709 are all Duck numbers. 
 * Please note that a numbers with only leading 0s is not considered as Duck Number.
 */

public class DuckNumber {

    public static void main(String[] args) {
        String num = "1023";
        if (isDuckNumber(num))
            System.out.println(num + " is a duck number");
        else
            System.out.println(num + " is not a duck number");
    }

    public static boolean isDuckNumber(String s) {
        boolean result = false;
        int i = 0;
        int length = s.length();

        // Ignore leading 0s
        while (i < length && s.charAt(i) == '0') {
            i++;
        }
        // Check remaining digits
        while (i < length) {
            if (s.charAt(i) == '0') {
                result = true;
                break;
            }
            i++;
        }
        return result;
    }

}
