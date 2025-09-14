import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class SingleNum {
    

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNum solution = new SingleNum();

        // Test cases for containsDuplicate
        
        System.out.println("\nTesting singleNumber:");
        // Test cases for singleNumber
        int[] nums5 = {2, 2, 1};
        System.out.println("The single number in " + Arrays.toString(nums5) + " is: " + solution.singleNumber(nums5)); // Expected: 1

        int[] nums6 = {4, 1, 2, 1, 2};
        System.out.println("The single number in " + Arrays.toString(nums6) + " is: " + solution.singleNumber(nums6)); // Expected: 4

        int[] nums7 = {1};
        System.out.println("The single number in " + Arrays.toString(nums7) + " is: " + solution.singleNumber(nums7)); // Expected: 1
    }
}
