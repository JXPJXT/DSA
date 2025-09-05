import java.util.HashMap;

class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (prefix[j] == k) count++;

            int val = prefix[j] - k;
            if (map.containsKey(val)) {
                count += map.get(val);
            }
            map.put(prefix[j], map.getOrDefault(prefix[j], 0) + 1);
        }
        return count;
    }
}

public class SubarraySum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + solution.subarraySum(nums1, k1)); // Expected output: 2

        System.out.println();

        // Example 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + solution.subarraySum(nums2, k2)); // Expected output: 2
    }
}
