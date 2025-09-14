import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};
        
        System.out.println("Original array: " + Arrays.toString(nums));

        solution.sortColors(nums);

        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
