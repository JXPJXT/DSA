class Solution {
    public int uniquePaths(int m, int n) {
        int[] aboveRow = new int[n];
        java.util.Arrays.fill(aboveRow, 1);

        for (int row = 1; row < m; row++) {
            int[] currentRow = new int[n];
            java.util.Arrays.fill(currentRow, 1);
            for (int col = 1; col < n; col++) {
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            aboveRow = currentRow;
        }

        return aboveRow[n - 1];
    }
}

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int m1 = 3;
        int n1 = 7;
        System.out.println("Unique paths for a " + m1 + "x" + n1 + " grid: " + solution.uniquePaths(m1, n1));
        System.out.println("---");

        // Test case 2
        int m2 = 3;
        int n2 = 2;
        System.out.println("Unique paths for a " + m2 + "x" + n2 + " grid: " + solution.uniquePaths(m2, n2));
        System.out.println("---");
        
        // Test case 3
        int m3 = 7;
        int n3 = 3;
        System.out.println("Unique paths for a " + m3 + "x" + n3 + " grid: " + solution.uniquePaths(m3, n3));
        System.out.println("---");
    }
}
