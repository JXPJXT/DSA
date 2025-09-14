import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int rows = heights.length;
        int cols = heights[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0, 0});
        
        int[] effortToReach = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            effortToReach[i] = Integer.MAX_VALUE;
        }
        effortToReach[0] = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int effort = current[0];
            int curRow = current[1];
            int curCol = current[2];

            if (effort > effortToReach[curRow * cols + curCol]) {
                continue;
            }

            if (curRow == rows - 1 && curCol == cols - 1) {
                return effort;
            }

            for (int[] direction : directions) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[curRow][curCol]));
                    if (newEffort < effortToReach[newRow * cols + newCol]) {
                        effortToReach[newRow * cols + newCol] = newEffort;
                        minHeap.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }

        return effortToReach[rows * cols - 1];
    }

    public static void main(String[] args) {
        MinimumEffortPath solution = new MinimumEffortPath();

        // Test Case 1
        int[][] heights1 = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println("Test Case 1: " + solution.minimumEffortPath(heights1)); // Expected output: 2

        // Test Case 2
        int[][] heights2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        System.out.println("Test Case 2: " + solution.minimumEffortPath(heights2)); // Expected output: 1

        // Test Case 3
        int[][] heights3 = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println("Test Case 3: " + solution.minimumEffortPath(heights3)); // Expected output: 0
    }
}
