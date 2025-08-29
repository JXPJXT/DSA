import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 2, 3};
        System.out.println("Input: {3, 2, 3}");
        System.out.println("Majority Element: " + solution.majorityElement(nums1)); 
        System.out.println("---");
        
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input: {2, 2, 1, 1, 1, 2, 2}");
        System.out.println("Majority Element: " + solution.majorityElement(nums2));
        System.out.println("---");
        
        int[] nums3 = {1};
        System.out.println("Input: {1}");
        System.out.println("Majority Element: " + solution.majorityElement(nums3));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > n / 2) {
                return num;
            }
        }
        
        return -1;
    }
}