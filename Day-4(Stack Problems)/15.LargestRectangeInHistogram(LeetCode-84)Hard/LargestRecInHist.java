import java.util.Stack;

class LargestRectInHist {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectInHist solution = new LargestRectInHist();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.print("Input: {2, 1, 5, 6, 2, 3}\nOutput: ");
        System.out.println(solution.largestRectangleArea(heights1));

        int[] heights2 = {2, 4};
        System.out.print("\nInput: {2, 4}\nOutput: ");
        System.out.println(solution.largestRectangleArea(heights2));
    }
}
