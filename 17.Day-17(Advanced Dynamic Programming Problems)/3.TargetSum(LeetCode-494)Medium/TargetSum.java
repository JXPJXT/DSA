import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);

        for (int n : nums) {
            Map<Integer, Integer> temp = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();

                temp.put(total + n, temp.getOrDefault(total + n, 0) + count);
                temp.put(total - n, temp.getOrDefault(total - n, 0) + count);
            }
            counter = temp;
        }

        return counter.getOrDefault(target, 0);
    }
}

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("Nums: " + java.util.Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Number of ways: " + solution.findTargetSumWays(nums1, target1)); // Expected: 5
        System.out.println("---");

        // Test case 2
        int[] nums2 = {1};
        int target2 = 1;
        System.out.println("Nums: " + java.util.Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Number of ways: " + solution.findTargetSumWays(nums2, target2)); // Expected: 1
        System.out.println("---");
    }
}
