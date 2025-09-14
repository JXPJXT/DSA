import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}

public class ProductOfArrExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(solution.productExceptSelf(nums1)));
        System.out.println("---");

        int[] nums2 = {0, 1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.productExceptSelf(nums2)));
        System.out.println("---");
        
        int[] nums3 = {-1, 1, 0, -3, 0};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(solution.productExceptSelf(nums3)));
        System.out.println("---");
    }
}
