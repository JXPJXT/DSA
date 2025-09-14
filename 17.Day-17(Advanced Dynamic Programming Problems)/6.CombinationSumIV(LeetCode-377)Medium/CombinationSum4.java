import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return helper(nums, target, memo);
    }

    int helper(int[] nums, int target, Integer[] memo) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (memo[target] != null) return memo[target];

        int count = 0;
        for (int num : nums) {
            count += helper(nums, target - num, memo);
        }
        memo[target] = count;
        return count;
    }
}

public class CombinationSum4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println("Nums: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Number of combinations: " + solution.combinationSum4(nums1, target1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {9};
        int target2 = 3;
        System.out.println("Nums: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Number of combinations: " + solution.combinationSum4(nums2, target2));
        System.out.println("---");
        
        // Test case 3
        int[] nums3 = {4,2,1};
        int target3 = 32;
        System.out.println("Nums: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Number of combinations: " + solution.combinationSum4(nums3, target3));
        System.out.println("---");
    }
}
