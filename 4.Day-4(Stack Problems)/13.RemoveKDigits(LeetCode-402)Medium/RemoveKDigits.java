import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        while (k > 0) {
            stack.pop();
            k--;            
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        
        String num1 = "1432219";
        int k1 = 3;
        System.out.println("Input: num = \"" + num1 + "\", k = " + k1);
        System.out.println("Output: " + solution.removeKdigits(num1, k1));

        String num2 = "10200";
        int k2 = 1;
        System.out.println("\nInput: num = \"" + num2 + "\", k = " + k2);
        System.out.println("Output: " + solution.removeKdigits(num2, k2));
    }
}
