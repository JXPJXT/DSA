class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[targetSum]) return true;
            }
        }
        return dp[targetSum];
    }
}

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Array: " + java.util.Arrays.toString(nums1));
        System.out.println("Can partition into two equal subsets? " + solution.canPartition(nums1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Array: " + java.util.Arrays.toString(nums2));
        System.out.println("Can partition into two equal subsets? " + solution.canPartition(nums2));
        System.out.println("---");

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Array: " + java.util.Arrays.toString(nums3));
        System.out.println("Can partition into two equal subsets? " + solution.canPartition(nums3));
        System.out.println("---");
    }
}
