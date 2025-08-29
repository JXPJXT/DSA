class MoveZero {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MoveZero solution = new MoveZero();

        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.print("Input: nums = [0, 1, 0, 3, 12]");
        solution.moveZeroes(nums1);
        System.out.print(" Output: [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i < nums1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("--------------------");

        int[] nums2 = {0};
        System.out.print("Input: nums = [0]");
        solution.moveZeroes(nums2);
        System.out.print(" Output: [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i < nums2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}