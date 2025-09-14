import java.util.Arrays;
import java.lang.Math;

public class SortedSquares {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-4, -1, 0, 3, 10};
        
        System.out.println("Original array: " + Arrays.toString(nums));

        int[] sortedSquaresArray = solution.sortedSquares(nums);
        
        System.out.println("Sorted squares array: " + Arrays.toString(sortedSquaresArray));
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n-1;
        for(int i = n-1;i>=0;i--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                ans[i] = nums[left] * nums[left];
                left++;
            }
            else{
                ans[i] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
