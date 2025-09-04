import java.util.Stack;

class RemAllAdjacent {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == ch) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch1 : stk) {
            sb.append(ch1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemAllAdjacent solution = new RemAllAdjacent();
        String input = "abbaca";
        String result = solution.removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("Result: " + result);

        String input2 = "azxxzy";
        String result2 = solution.removeDuplicates(input2);
        System.out.println("\nInput: " + input2);
        System.out.println("Result: " + result2);
    }
}
