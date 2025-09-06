import java.util.ArrayList;
import java.util.Arrays;

public class SortArrByParity {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 2, 4};
        System.out.println("Original array: " + Arrays.toString(nums));
        int[] sortedNums = solution.sortArrayByParity(nums);
        System.out.println("Sorted by parity: " + Arrays.toString(sortedNums));
    }
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer>li=new ArrayList<>();
        int evenCount=0;
        int oddCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                li.add(nums[i]);
                oddCount++;
            }
            else{
                nums[evenCount]=nums[i];
                evenCount++;
            }
        }
        int k=0;
        while(k<oddCount){
            nums[evenCount++]=li.get(k);
            k++;
        }
        return nums;
    }
}
