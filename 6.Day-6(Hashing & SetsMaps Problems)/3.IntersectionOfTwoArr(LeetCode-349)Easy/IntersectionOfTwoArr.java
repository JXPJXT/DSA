import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        boolean[] seen = new boolean[1001];
        for (int num : nums1) {
            if (num >= 0 && num < seen.length) {
                seen[num] = true;
            }
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;
        for (int num : nums2) {
            if (num >= 0 && num < seen.length) {
                if (seen[num] == true) {
                    result[idx++] = num;
                    seen[num] = false;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, idx);
    }
}

public class IntersectionOfTwoArr {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = solution.intersection(nums1, nums2);

        System.out.println("First array: " + Arrays.toString(nums1));
        System.out.println("Second array: " + Arrays.toString(nums2));
        System.out.println("Intersection: " + Arrays.toString(result));

        System.out.println("---");
        int[] nums3 = {1, 2, 2, 1};
        int[] nums4 = {2, 2};
        int[] result2 = solution.intersection(nums3, nums4);
        System.out.println("First array: " + Arrays.toString(nums3));
        System.out.println("Second array: " + Arrays.toString(nums4));
        System.out.println("Intersection: " + Arrays.toString(result2));
    }
}
