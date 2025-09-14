class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int lessEqual(int[][] matrix, int target) {
        int count = 0, len = matrix.length, i = len - 1, j = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallest solution = new KthSmallest();
        int[][] matrix1 = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k1 = 8;
        System.out.println("Matrix:");
        for (int[] row : matrix1) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println("k = " + k1);
        System.out.println("The " + k1 + "th smallest element is: " + solution.kthSmallest(matrix1, k1));
    }
}
