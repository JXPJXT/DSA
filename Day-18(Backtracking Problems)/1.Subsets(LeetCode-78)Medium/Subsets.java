import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(nums, 0, currentSubset, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        currentSubset.add(nums[index]);
        backtrack(nums, index + 1, currentSubset, result);
        currentSubset.remove(currentSubset.size() - 1);
        backtrack(nums, index + 1, currentSubset, result);
    }
}

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println("Input nums: " + Arrays.toString(nums));
        System.out.println("All subsets: " + subsets);
    }
}
