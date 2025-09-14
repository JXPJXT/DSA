import java.util.HashSet;

class ContainsDuplicateOptimized {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}

class ContainsDupOptimized {
    public static void main(String[] args) {
        ContainsDuplicateOptimized solution = new ContainsDuplicateOptimized();

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