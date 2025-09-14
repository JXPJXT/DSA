import java.util.Arrays;

public class MissingNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Original array: " + Arrays.toString(nums));

        int missingNumberSum = solution.missingNumber(nums.clone());
        System.out.println("The missing number (using sum method) is: " + missingNumberSum);

        int missingNumberSorted = solution.missingNumberSorted(nums);
        System.out.println("The missing number (using sort method) is: " + missingNumberSorted);
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int actualSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            expectedSum += i;
            if (i == nums.length) {
                break;
            }
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }

    public int missingNumberSorted(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
}
