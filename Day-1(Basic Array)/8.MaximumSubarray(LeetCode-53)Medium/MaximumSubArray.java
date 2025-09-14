public class MaximumSubArray{
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums1)); 
        System.out.println("---");

        int[] nums2 = {-1, -2, -3, -4};
        System.out.println("Input: [-1, -2, -3, -4]");
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums2));
        System.out.println("---");

        int[] nums3 = {5};
        System.out.println("Input: [5]");
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums3));
        System.out.println("---");
        
        int[] nums4 = {1, 2, -1, 3, -2, 5};
        System.out.println("Input: [1, 2, -1, 3, -2, 5]");
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums4));
        System.out.println("---");
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentMax = nums[0];
        int Max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            if (currentMax > Max) {
                Max = currentMax;
            }
        }
        return Max;
    }
}
