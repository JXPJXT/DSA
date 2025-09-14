import java.util.Stack;

class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Define a list of test cases
        String[] testStrings = {
            "()",          // Valid
            "()[]{}",      // Valid
            "(]",          // Invalid
            "([)]",        // Invalid
            "{[]}",        // Valid
            "",            // Valid (empty string)
            "((()))",      // Valid
            "({[",         // Invalid
            "}}}",         // Invalid
            "{[()]}"       // Valid
        };

        System.out.println("Testing the isValid method with various strings:");
        System.out.println("----------------------------------------------");

        // Loop through each test case and print the result
        for (String testCase : testStrings) {
            boolean result = solution.isValid(testCase);
            System.out.printf("String: \"%s\" -> Is Valid: %s%n", testCase, result);
        }
    }
}
