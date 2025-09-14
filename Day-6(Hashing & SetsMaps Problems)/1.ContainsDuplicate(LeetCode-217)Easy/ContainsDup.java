import java.util.HashSet;
import java.util.Set;

class ContainsDup {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Contains duplicates
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Does [1, 2, 3, 1] contain duplicates? " + solution.containsDuplicate(nums1)); // Expected: true

        // Test case 2: No duplicates
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Does [1, 2, 3, 4] contain duplicates? " + solution.containsDuplicate(nums2)); // Expected: false

        // Test case 3: Empty array
        int[] nums3 = {};
        System.out.println("Does [] contain duplicates? " + solution.containsDuplicate(nums3)); // Expected: false

        // Test case 4: Single element
        int[] nums4 = {5};
        System.out.println("Does [5] contain duplicates? " + solution.containsDuplicate(nums4)); // Expected: false
    }
}
