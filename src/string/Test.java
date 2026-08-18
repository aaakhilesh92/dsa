package string;

public class Test {
    public static void main(String[] args) {
        String s = "0081";
        int num = Integer.parseInt(s);
        int n = s.length();
        int[] arr = new int[n];
        int digitSum = 0;
        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            digitSum += digit;
            arr[i] = digit;
        }
        int i = 0;
        int count = 0;
        while (i < n) {
            int curr_digit = arr[i];
            int digit_sum = digitSum - curr_digit;
            for (int k = 0; k <= 9; k++) {
                if (curr_digit == k) {
                    continue;
                } else {
                    if ((digit_sum + k) % 3 == 0) {
                        count++;
                    }
                }
            }
            i++;
        }

        System.out.println("count:" + count);
    }
}
