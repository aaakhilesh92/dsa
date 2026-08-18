  package number;

public class Palindrome {

    public static void isPalindrome(String a) {
        int low = 0;
        int high = a.length() - 1;
        while (low < high) {
            if (a.charAt(low++) != a.charAt(high--)) {
                System.out.println("String : " + a + " is not Palindrome");
                return;
            }
        }
        System.out.println("String : " + a + " is Palindrome");
    }

    public static void isPalindrome(int num) {
        int originalNum = num;
        int reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }
        if (originalNum == reverse) {
            System.out.println("Number : " + originalNum + " is Palindrome");
        } else {
            System.out.println("Number is not Palindrome");
        }
    }

    // A function that returns true only if num contains one digit
    public static int oneDigit(int num) {
        if ((num >= 0) && (num < 10))
            return 1;
        else
            return 0;
    }

    public static int isPalindromeRec(int num, int dupNum) throws Exception {

        // base condition to return once we move past first digit
        if (num == 0) {
            return dupNum;
        } else {
            dupNum = isPalindromeRec(num / 10, dupNum);
        }

        // Check for equality of first digit of num and dupNum
        if (num % 10 == dupNum % 10) {
            // if first digit values of num and dupNum are equal divide dupNum
            // value by 10 to keep moving in sync with num.
            return dupNum / 10;
        } else {// At position values are not matching throw exception and exit. no need to proceed further.
            throw new Exception();
        }

    }

    public static int isPalindromeRecursion(int num) throws Exception {
        if (num < 0) {
            num = (-num);
        }
        int dupNum = (num);
        return isPalindromeRec(num, dupNum);
    }

    public static void main(String[] args) {
        isPalindrome("abc");
        isPalindrome(-2);
        int n = 12421;
        try {
            isPalindromeRecursion(n);
            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }
    }

}
