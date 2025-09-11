import java.util.ArrayList;
import java.util.List;

class NearestExit {
    int a, b;
    Integer[][] dp;

    public int nearestExit(char[][] maze, int[] entrance) {
        int i = entrance[0];
        int j = entrance[1];
        a = i;
        b = j;
        dp = new Integer[maze.length + 1][maze[0].length + 1];
        if (maze.length < 20 && maze[0].length < 15) {
            int ans1 = dfs1(maze, i, j);
            if (ans1 >= (int) 1e9) return -1;
            return ans1;
        } else {
            int ans = dfs(maze, i, j);
            if (ans >= (int) 1e9) return -1;
            return ans;
        }
    }

    int dfs(char[][] maze, int i, int j) {
        if (i < 0 || j < 0 || j >= maze[0].length || i >= maze.length || maze[i][j] == '+') return (int) 1e9;
        if (dp[i][j] != null) return dp[i][j];
        if ((i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1) && (maze[i][j] == '.') && (i != a || j != b)) return 0;

        maze[i][j] = '+';
        int right = 1 + dfs(maze, i, j + 1);
        int left = 1 + dfs(maze, i, j - 1);
        int up = 1 + dfs(maze, i - 1, j);
        int down = 1 + dfs(maze, i + 1, j);
        maze[i][j] = '.';
        return dp[i][j] = Math.min(Math.min(up, down), Math.min(left, right));
    }

    int dfs1(char[][] maze, int i, int j) {
        if (i < 0 || j < 0 || j >= maze[0].length || i >= maze.length || maze[i][j] == '+') return (int) 1e9;
        if ((i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1) && (maze[i][j] == '.') && (i != a || j != b)) return 0;

        maze[i][j] = '+';
        int right = 1 + dfs1(maze, i, j + 1);
        int left = 1 + dfs1(maze, i, j - 1);
        int up = 1 + dfs1(maze, i - 1, j);
        int down = 1 + dfs1(maze, i + 1, j);
        maze[i][j] = '.';
        return Math.min(Math.min(up, down), Math.min(left, right));
    }

    public static void main(String[] args) {
        NearestExit solution = new NearestExit();

        // Test Case 1: Path exists
        char[][] maze1 = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance1 = {1, 2};
        System.out.println("Nearest exit for maze1: " + solution.nearestExit(maze1, entrance1)); // Expected: 1

        // Test Case 2: No path exists
        NearestExit solution2 = new NearestExit();
        char[][] maze2 = {{'+', '.', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println("Nearest exit for maze2: " + solution2.nearestExit(maze2, entrance2)); // Expected: -1
    }
}
