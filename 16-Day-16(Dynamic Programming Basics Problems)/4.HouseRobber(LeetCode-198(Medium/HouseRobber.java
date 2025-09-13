class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];        
    }
}

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println("Nights: " + java.util.Arrays.toString(nums1));
        System.out.println("Maximum amount to rob: " + solution.rob(nums1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Nights: " + java.util.Arrays.toString(nums2));
        System.out.println("Maximum amount to rob: " + solution.rob(nums2));
        System.out.println("---");
    }
}
