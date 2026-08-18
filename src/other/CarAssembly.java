package other;

public class CarAssembly {

    public static int solution(int[] A, int[] B, int X, int Y) {
        // Implement your solution here

        int n = A.length;
        int first = A[0];
        int second = B[0];
        for (int i = 1; i < n; i++) {
            int up = Math.min(first + A[i], second + Y + A[i]);
            int down = Math.min(second + B[i], first + X + B[i]);
            first = up;
            second = down;
        }
        return Math.min(first, second);
    }
    public static void main(String[] args) {
        //int[]A= {1,6,2}; int []B = {3,2,5}; int X=2; int Y=1; //Ans = 8
         int[]A= {2,11,4, 4}; int[]B= {9,2,5,11}; int X=8; int Y=4; //Ans = 21
        //int[]A= {1,10,1}; int[]B = {10,1,10}; int X=1; int Y=5; //ans = 9
        // int[]A=[8,3,3]; int[]B = {6,1,10}; int X=4; int Y=3;// Ans = 13
        System.out.println(solution(A, B, X, Y));
    }

}
