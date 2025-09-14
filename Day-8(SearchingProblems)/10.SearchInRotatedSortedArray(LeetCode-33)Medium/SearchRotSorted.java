class SearchRotSorted {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotSorted solution = new SearchRotSorted();
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("The index of the target is: " + solution.search(nums1, target1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("The index of the target is: " + solution.search(nums2, target2));
    }
}