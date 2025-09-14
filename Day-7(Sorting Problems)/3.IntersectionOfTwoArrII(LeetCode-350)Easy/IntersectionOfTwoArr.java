import java.util.Arrays;

public class IntersectionOfTwoArr {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Define two example arrays
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        
        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Array 2: " + Arrays.toString(nums2));

        // Call the intersect method and store the result
        int[] intersection = solution.intersect(nums1, nums2);

        // Print the intersection array
        System.out.println("Intersection: " + Arrays.toString(intersection));
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
