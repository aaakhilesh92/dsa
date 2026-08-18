package array;


public class ArrayBeA {
    private int count = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
        	ArrayBeA obj = new ArrayBeA();
            System.out.println("arrangementCount for value:" + i + " -  " + obj.countArrangement(i));
        }

    }

    public int countArrangement2(int N) {
        if (N == 0)
            return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }

    public int countArrangement(int N) {
        dfs(N, N, new boolean[N + 1]);
        return count;
    }

    void dfs(int N, int k, boolean[] visited) {
        if (k == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] || k % i != 0 && i % k != 0) {
                continue;
            }
            visited[i] = true;
            dfs(N, k - 1, visited);
            visited[i] = false;
        }
    }
}
