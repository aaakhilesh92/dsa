package array;

public class MoveElementToEndOfArray {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 3, 7, 3, 8};
        int k = 3;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                continue;
            if (k == arr[i]) {
                c++;
                continue;
            }
            arr[i - c] = arr[i];
        }
        for (int i = arr.length - c; i < arr.length; i++) {
            arr[i] = k;
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
