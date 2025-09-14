class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        int maxLen = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Array: " + java.util.Arrays.toString(nums1));
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Array: " + java.util.Arrays.toString(nums2));
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums2));
        System.out.println("---");
        
        // Test case 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Array: " + java.util.Arrays.toString(nums3));
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums3));
        System.out.println("---");
    }
}
