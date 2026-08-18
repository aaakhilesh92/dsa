package number;

public class AddLargeStringNumber {

    public static void main(String[] args) {
        System.out.println(addString2("1578", "599"));
    }

    public static String addString(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int i1 = str1.length() - 1;
        int i2 = str2.length() - 1;
        int carry = 0;
        while (i1 >= 0 && i2 >= 0) {
            int ch1 = Character.getNumericValue(str1.charAt(i1));
            int ch2 = Character.getNumericValue(str2.charAt(i2));
            int sum = ch1 + ch2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.append(Character.forDigit(remainder, 10));
            i1--;
            i2--;
        }

        String str;
        int i;
        if (i1 >= 0) {
            str = str1;
            i = i1;
        } else {
            str = str2;
            i = i2;
        }

        while (i >= 0) {
            int ch1 = Character.getNumericValue(str.charAt(i));
            int sum = ch1 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.append(Character.forDigit(remainder, 10));
            i--;
        }
        if (carry > 0) {
            sb.append(Character.forDigit(carry, 10));
        }

        return sb.reverse().toString();
    }

    public static String addString2(String str1, String str2) {
        // str2 is large string
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        StringBuilder sb = new StringBuilder();
        int n1 = str1.length();
        int n2 = str2.length();
        int i1 = n1 - 1;
        int i2 = n2 - 1;
        int carry = 0;
        while (i1 >= 0) {
            int digit1 = Character.getNumericValue(str1.charAt(i1));
            int digit2 = Character.getNumericValue(str2.charAt(i2));
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.append(Character.forDigit(remainder, 10));
            i1--;
            i2--;
        }

        while (i2 >= 0) {
            int digit = Character.getNumericValue(str2.charAt(i2));
            int sum = digit + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.append(Character.forDigit(remainder, 10));
            i2--;
        }
        if (carry > 0) {
            sb.append(Character.forDigit(carry, 10));
        }

        return sb.reverse().toString();
    }

    static String findSum(String str1, String str2) {
        // Before proceeding further, make sure length of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        StringBuilder sb = new StringBuilder();

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {
            int digit1 = (int) (str1.charAt(i) - '0');
            int digit2 = (int) (str2.charAt(i) - '0');
            int sum = digit1 + digit2 + carry;
            int remainder = sum % 10;
            remainder = remainder + '0';
            char ch = (char) remainder;
            sb.append(ch);
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++) {
            int digit = (int) (str2.charAt(i) - '0');
            int sum = digit + carry;
            int remainder = sum % 10;
            remainder = remainder + '0';
            char ch = (char) remainder;
            sb.append(ch);
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0) {
            sb.append((char) (carry + '0'));
        }

        // reverse resultant String
        return sb.reverse().toString();

    }

}
