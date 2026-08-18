package other;

public class Testing {
    public static int magicsticks(int input1, int[] input2, int[] input3) {
        int minimumSum = -1;
        for (int i = 0; i < input1; i++) {
            int min = 0;
            int length = input2[i];
            for (int j = 0; j < input1; j++) {
                min += Math.abs(input2[j] - length) * input3[j];
            }
            if (minimumSum == -1 || min < minimumSum) {
                minimumSum = min;
            }
        }
        return minimumSum;
    }

    public static void main(String[] args) {
        int input1 = 3;
        int[] input2 = {1, 2, 3};
        int[] input3 = {20, 30, 40};
        int s = magicsticks(input1, input2, input3);
        System.out.println(s);
    }
}