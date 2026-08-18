package bits;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(8));
        System.out.println(countSetBits(7));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(7));
    }

    public static int countSetBits(int num) {
        int result = 0;
        while (num > 0) {
            result++;
            num = num & (num - 1);
        }
        return result;
    }

    public static boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }
}
