import java.util.Stack;

class DailyTemps {
    public int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }

    public static void main(String[] args) {
        DailyTemps solution = new DailyTemps();
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temps1);
        System.out.print("Input: {73, 74, 75, 71, 69, 72, 76, 73}\nResult: {");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i == result1.length - 1 ? "" : ", "));
        }
        System.out.println("}");
        
        int[] temps2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temps2);
        System.out.print("\nInput: {30, 40, 50, 60}\nResult: {");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + (i == result2.length - 1 ? "" : ", "));
        }
        System.out.println("}");

        int[] temps3 = {30, 60, 90};
        int[] result3 = solution.dailyTemperatures(temps3);
        System.out.print("\nInput: {30, 60, 90}\nResult: {");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + (i == result3.length - 1 ? "" : ", "));
        }
        System.out.println("}");
    }
}
