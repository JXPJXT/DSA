import java.util.LinkedList;
import java.util.Queue;

class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // If the start or end is blocked, a path is not possible.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        
        // Queue for BFS, storing {row, column, steps}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        
        // All 8 possible directions (up, down, left, right, and diagonals)
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        // Mark the starting cell as visited by changing its value.
        grid[0][0] = -1;
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            int steps = temp[2];

            // If we have reached the destination, return the number of steps.
            if (i == n - 1 && j == n - 1) {
                return steps;
            }

            // Explore all 8 neighbors
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                
                // Check if the new position is within bounds and is a valid path (value is 0)
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 0) {
                    // Add the new valid position to the queue
                    queue.add(new int[]{ni, nj, steps + 1});
                    
                    // Mark the cell as visited
                    grid[ni][nj] = -1;
                }
            }
        }
        
        // If the queue becomes empty and the target is not reached, a path does not exist.
        return -1;
    }
    
    public static void main(String[] args) {
        ShortestPathBinaryMatrix solution = new ShortestPathBinaryMatrix();

        // Test Case 1
        int[][] grid1 = {{0, 1}, {1, 0}};
        System.out.println("Shortest path for grid1: " + solution.shortestPathBinaryMatrix(grid1)); // Expected: 2

        // Test Case 2
        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println("Shortest path for grid2: " + solution.shortestPathBinaryMatrix(grid2)); // Expected: 4

        // Test Case 3 (No path)
        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println("Shortest path for grid3: " + solution.shortestPathBinaryMatrix(grid3)); // Expected: -1
    }
}
