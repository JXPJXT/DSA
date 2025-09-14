import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
}

public class MinPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("Grid:");
        for (int[] row : grid1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Minimum path sum: " + solution.minPathSum(grid1));
        System.out.println("---");

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Grid:");
        for (int[] row : grid2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Minimum path sum: " + solution.minPathSum(grid2));
        System.out.println("---");
    }
}
