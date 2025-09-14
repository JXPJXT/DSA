import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else {
                    if (c > 0) {
                        dp[c] += dp[c - 1];
                    }
                }
            }
        }

        return dp[cols - 1];
    }
}

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: No obstacles
        int[][] grid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Grid 1:");
        for (int[] row : grid1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of unique paths: " + solution.uniquePathsWithObstacles(grid1));
        System.out.println("---");

        // Test case 2: Obstacle at the start
        int[][] grid2 = {{1}};
        System.out.println("Grid 2:");
        for (int[] row : grid2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of unique paths: " + solution.uniquePathsWithObstacles(grid2));
        System.out.println("---");
        
        // Test case 3: Obstacle blocking the path
        int[][] grid3 = {{0, 0}, {0, 1}};
        System.out.println("Grid 3:");
        for (int[] row : grid3) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of unique paths: " + solution.uniquePathsWithObstacles(grid3));
        System.out.println("---");
    }
}
