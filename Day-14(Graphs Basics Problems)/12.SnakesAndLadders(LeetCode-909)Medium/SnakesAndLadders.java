import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        final int n = board.length;
        Queue<Integer> q = new ArrayDeque<>(List.of(1));
        boolean[] seen = new boolean[1 + n * n];
        int[] arr = new int[1 + n * n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                arr[(n - 1 - i) * n + ((n - i) % 2 == 0 ? n - j : j + 1)] = board[i][j];

        for (int step = 1; !q.isEmpty(); ++step)
            for (int sz = q.size(); sz > 0; --sz) {
                final int curr = q.poll();
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); ++next) {
                    final int dest = arr[next] > 0 ? arr[next] : next;
                    if (dest == n * n)
                        return step;
                    if (seen[dest])
                        continue;
                    q.offer(dest);
                    seen[dest] = true;
                }
            }

        return -1;
    }

    public static void main(String[] args) {
        SnakesAndLadders solution = new SnakesAndLadders();

        // Test Case 1: Example from LeetCode
        int[][] board1 = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        System.out.println("Minimum moves for board 1: " + solution.snakesAndLadders(board1)); // Expected: 4

        // Test Case 2: No snakes or ladders
        int[][] board2 = {
            {-1, -1},
            {-1, -1}
        };
        System.out.println("Minimum moves for board 2: " + solution.snakesAndLadders(board2)); // Expected: 1
    }
}
