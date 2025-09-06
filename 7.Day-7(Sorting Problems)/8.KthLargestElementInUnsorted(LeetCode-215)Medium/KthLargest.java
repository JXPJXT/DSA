import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("The " + k2 + "th largest element is: " + result2);
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k || nums.length == 0 || k <= 0){
            // Handle edge cases where k is out of bounds
            throw new IllegalArgumentException("Invalid k value or empty array");
        }
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}
