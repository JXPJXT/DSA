class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int total = 0;

        for (int n : nums) {
            if (total < 0) {
                total = 0;
            }

            total += n;
            res = Math.max(res, total);
        }

        return res;        
    }
}

public class MaxSubArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + java.util.Arrays.toString(nums1));
        System.out.println("Maximum subarray sum is: " + solution.maxSubArray(nums1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {1};
        System.out.println("Array: " + java.util.Arrays.toString(nums2));
        System.out.println("Maximum subarray sum is: " + solution.maxSubArray(nums2));
        System.out.println("---");

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Array: " + java.util.Arrays.toString(nums3));
        System.out.println("Maximum subarray sum is: " + solution.maxSubArray(nums3));
        System.out.println("---");
    }
}
