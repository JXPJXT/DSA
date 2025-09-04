import java.util.Stack;

class GreatStr {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        GreatStr solution = new GreatStr();
        String input1 = "leEeetcode";
        String result1 = solution.makeGood(input1);
        System.out.println("Input: " + input1);
        System.out.println("Result: " + result1);

        String input2 = "abBAcC";
        String result2 = solution.makeGood(input2);
        System.out.println("\nInput: " + input2);
        System.out.println("Result: " + result2);
    }
}
