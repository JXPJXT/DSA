class TwoSumBrute {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

public class TwoSumBruteForce{
    public static void main(String[] args) {
        TwoSumBrute solution = new TwoSumBrute();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

        System.out.println("--------------------");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = [3, 2, 4], target = 6");
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");

        System.out.println("--------------------");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = [3, 3], target = 6");
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
    }
}