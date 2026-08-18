package array;

public class ArrayBeautifulArrangement2 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            ArrayBeautifulArrangement2 obj = new ArrayBeautifulArrangement2();
            System.out.println("arrangementCount for value:" + i + " -  " + obj.countArrangement(i));
        }
    }

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        return process(1, visited);
    }

    private int process(int start, boolean[] visited) {
        if (start == visited.length) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false && (start % i == 0 || i % start == 0)) {
                visited[i] = true;
                count += process(start + 1, visited);
                visited[i] = false;
            }
        }
        return count;
    }
}
