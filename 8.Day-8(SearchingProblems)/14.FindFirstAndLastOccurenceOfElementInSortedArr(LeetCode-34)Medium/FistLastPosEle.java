class FirLasPosEle {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = findBound(nums, target, true);
        if (left == -1) {
            return result;
        }
        int right = findBound(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FirLasPosEle solution = new FirLasPosEle();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("The first and last positions of " + target + " are: [" + result[0] + ", " + result[1] + "]");

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("The first and last positions of " + target2 + " are: [" + result2[0] + ", " + result2[1] + "]");
    }
}