class MinInRotSorted {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        MinInRotSorted solution = new MinInRotSorted();
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("The minimum element is: " + solution.findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("The minimum element is: " + solution.findMin(nums2));
    }
}