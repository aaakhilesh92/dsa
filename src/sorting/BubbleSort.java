package sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 20, 10, 40, 50, 30 };
        sort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        boolean flag = false;
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
        } while (flag);
    }
}
