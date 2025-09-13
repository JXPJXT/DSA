class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));        
    }

    private int getMax(int[] nums, int start, int end) {
        int prevRob = 0, maxRob = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }    
}

public class HouseRobber2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from problem description
        int[] nums1 = {2, 3, 2};
        System.out.println("Array: " + java.util.Arrays.toString(nums1));
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums1));
        System.out.println("---");

        // Test case 2
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Array: " + java.util.Arrays.toString(nums2));
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums2));
        System.out.println("---");
        
        // Test case 3
        int[] nums3 = {0};
        System.out.println("Array: " + java.util.Arrays.toString(nums3));
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums3));
        System.out.println("---");
    }
}
