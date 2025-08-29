import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        for(int i=nums.length-1;i>0;i--){
            
            if(nums[i]<nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}

public class MinInRotatedSorted{
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Standard rotated array
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Minimum element: " + solution.findMin(nums1)); 
        System.out.println("---");

        // Example 2: Array that is not rotated
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Minimum element: " + solution.findMin(nums2));
        System.out.println("---");
        
        // Example 3: Array with a single element
        int[] nums3 = {1};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Minimum element: " + solution.findMin(nums3));
        System.out.println("---");

        // Example 4: Array with a rotation point in the middle
        int[] nums4 = {3, 4, 5, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Minimum element: " + solution.findMin(nums4));
        System.out.println("---");
    }
}
