import java.util.Stack;
import java.util.Arrays;

class NextGreater2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            int num = i % n;
            while (!s1.isEmpty() && nums[num] > nums[s1.peek()]) {
                ans[s1.pop()] = nums[num];
            }
            if (i < n) s1.push(i);
        }
        return ans; 
    }

    public static void main(String[] args) {
        NextGreater2 solution = new NextGreater2();
        
        int[] nums1 = {1, 2, 1};
        int[] result1 = solution.nextGreaterElements(nums1);
        System.out.print("Input: {1, 2, 1}\nResult: {");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i == result1.length - 1 ? "" : ", "));
        }
        System.out.println("}");

        int[] nums2 = {1, 2, 3, 4, 3};
        int[] result2 = solution.nextGreaterElements(nums2);
        System.out.print("\nInput: {1, 2, 3, 4, 3}\nResult: {");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + (i == result2.length - 1 ? "" : ", "));
        }
        System.out.println("}");
    }
}
