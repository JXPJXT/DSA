class ContainsDuplicateBrute {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

class ContainsDupBrute {
    public static void main(String[] args) {
        ContainsDuplicateBrute solution = new ContainsDuplicateBrute();

        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = solution.containsDuplicate(nums1);
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Output: " + result1);

        System.out.println("--------------------");

        int[] nums2 = {1, 2, 3, 4};
        boolean result2 = solution.containsDuplicate(nums2);
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Output: " + result2);

        System.out.println("--------------------");

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean result3 = solution.containsDuplicate(nums3);
        System.out.println("Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]");
        System.out.println("Output: " + result3);
    }
}