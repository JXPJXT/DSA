import java.util.Arrays;
import java.util.Stack;

class NextGreater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[10001];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1_1 = {4, 1, 2};
        int[] nums2_1 = {1, 3, 4, 2};
        int[] result1 = solution.nextGreaterElement(nums1_1, nums2_1);
        System.out.println(Arrays.toString(result1));

        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        int[] result2 = solution.nextGreaterElement(nums1_2, nums2_2);
        System.out.println(Arrays.toString(result2));
    }
}
