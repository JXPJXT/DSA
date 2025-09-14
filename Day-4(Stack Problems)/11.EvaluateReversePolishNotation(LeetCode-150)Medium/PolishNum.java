import java.util.Stack;

class PolishNum {
    public int evalRPN(String[] tokens) {
        int i = -1;
        for (String s : tokens) {
            if (s.equals("+")) {
                tokens[i - 1] = String.valueOf(
                    Integer.parseInt(tokens[i - 1]) + Integer.parseInt(tokens[i--]));
            } else if (s.equals("-")) {
                tokens[i - 1] = String.valueOf(
                    Integer.parseInt(tokens[i - 1]) - Integer.parseInt(tokens[i--]));
            } else if (s.equals("*")) {
                tokens[i - 1] = String.valueOf(
                    Integer.parseInt(tokens[i - 1]) * Integer.parseInt(tokens[i--]));
            } else if (s.equals("/")) {
                tokens[i - 1] = String.valueOf(
                    Integer.parseInt(tokens[i - 1]) / Integer.parseInt(tokens[i--]));
            } else {
                tokens[++i] = s;
            }
        }
        return Integer.valueOf(tokens[0]);
    }

    public static void main(String[] args) {
        PolishNum solution = new PolishNum();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Input: {\"2\", \"1\", \"+\", \"3\", \"*\"}");
        System.out.println("Result: " + solution.evalRPN(tokens1));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("\nInput: {\"4\", \"13\", \"5\", \"/\", \"+\"}");
        System.out.println("Result: " + solution.evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("\nInput: {\"10\", \"6\", \"9\", \"3\", \"+\", \"-11\", \"*\", \"/\", \"*\", \"17\", \"+\", \"5\", \"+\"}");
        System.out.println("Result: " + solution.evalRPN(tokens3));
    }
}
