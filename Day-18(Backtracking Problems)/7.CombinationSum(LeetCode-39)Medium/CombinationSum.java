import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void solve(int[] nums, int rem, List<Integer> comb, int start, List<List<Integer>> res) {
        if (rem == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if (rem < 0) return;

        for (int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            solve(nums, rem - nums[i], comb, i, res);
            comb.remove(comb.size() - 1);
        }
    }
}

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);
        System.out.println("Combinations for target " + target + " from candidates {2, 3, 6, 7}:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
