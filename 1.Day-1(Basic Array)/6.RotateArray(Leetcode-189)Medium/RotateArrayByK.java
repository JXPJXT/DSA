class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static void reverse(int[] nums, int st, int ed) {
        while (st < ed) {
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }
}

class RotateArrayByK {
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.print("Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3");
        solution.rotate(nums1, k1);
        System.out.print(" Output: [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i < nums1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("--------------------");

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.print("Input: nums = [-1, -100, 3, 99], k = 2");
        solution.rotate(nums2, k2);
        System.out.print(" Output: [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i < nums2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}