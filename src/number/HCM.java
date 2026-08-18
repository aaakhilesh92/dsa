package number;

public class HCM {
    public static void main(String[] args) {
        System.out.println(gcdRecursion(702, 786));
        int[] arr = { 2, 3, 8, 12, 15, 18 };
        System.out.println(findGCDArray(arr));
    }

    public static int findGCDArray(int arr[]) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            result = hcmTwoNumber(arr[i], result);

        return result;
    }

    public static int hcmTwoNumber(int a, int b) {
        int temp;
        int c = 0;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
            c++;
        }
        System.out.println("iteration - " + c);
        return a;
    }

    public static int gcdRecursion(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcdRecursion(b % a, a);
    }

    public static int gcdRecursion2(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcdRecursion2(a - b, b);

        return gcdRecursion2(a, b - a);
    }

    public static int hcmTwoNumber2(int a, int b) {
        int c = 0;
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println("iteration - " + c);
        return a;
    }
}
