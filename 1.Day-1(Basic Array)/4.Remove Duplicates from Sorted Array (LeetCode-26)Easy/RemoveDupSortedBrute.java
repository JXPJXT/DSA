class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}

class RemoveDupSortedBrute {
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        int[] nums1 = {1, 1, 2};
        int length1 = solution.removeDuplicates(nums1);
        System.out.println("Input: nums = [1, 1, 2]");
        System.out.print("Output: " + length1 + ", nums = [");
        for (int k = 0; k < length1; k++) {
            System.out.print(nums1[k] + (k < length1 - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("--------------------");

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length2 = solution.removeDuplicates(nums2);
        System.out.println("Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]");
        System.out.print("Output: " + length2 + ", nums = [");
        for (int k = 0; k < length2; k++) {
            System.out.print(nums2[k] + (k < length2 - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}