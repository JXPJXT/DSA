import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            ans.add(Arrays.asList(temp));
        }

        for (int i = 2; i < numRows; ++i) {
            for (int j = 1; j < ans.get(i).size() - 1; ++j) {
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }

        return ans;
    }
}

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int numRows1 = 5;
        System.out.println("Generating Pascal's Triangle for " + numRows1 + " rows:");
        List<List<Integer>> result1 = solution.generate(numRows1);
        for (List<Integer> row : result1) {
            System.out.println(row);
        }
        System.out.println("---");

        // Test case 2
        int numRows2 = 1;
        System.out.println("Generating Pascal's Triangle for " + numRows2 + " row:");
        List<List<Integer>> result2 = solution.generate(numRows2);
        for (List<Integer> row : result2) {
            System.out.println(row);
        }
        System.out.println("---");
    }
}
