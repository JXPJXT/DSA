import java.util.Arrays;

class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] memo;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];

        int maxLen = 1; 
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, x, y));
            }
        }
        memo[i][j] = maxLen;
        return maxLen;
    }
}

public class LongestIncreasingPath {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix1 = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Longest increasing path for matrix1 is: " + solution.longestIncreasingPath(matrix1));

        int[][] matrix2 = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println("Longest increasing path for matrix2 is: " + solution.longestIncreasingPath(matrix2));
    }
}
