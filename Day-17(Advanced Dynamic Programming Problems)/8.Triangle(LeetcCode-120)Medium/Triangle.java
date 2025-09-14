import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] memo = new int[row];

        for (int i = 0; i < row; i++) {
            memo[i] = triangle.get(row - 1).get(i);
        }

        for (int r = row - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                memo[c] = Math.min(memo[c], memo[c + 1]) + triangle.get(r).get(c);
            }
        }

        return memo[0];
    }
}

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        System.out.println("Triangle:");
        System.out.println(triangle1);
        System.out.println("Minimum total path: " + solution.minimumTotal(triangle1));
        System.out.println("---");

        // Test case 2
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        System.out.println("Triangle:");
        System.out.println(triangle2);
        System.out.println("Minimum total path: " + solution.minimumTotal(triangle2));
        System.out.println("---");
    }
}
