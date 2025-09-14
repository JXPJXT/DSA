import java.util.Stack;

class BackSpaceStrCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st1=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                st1.push(s.charAt(i));
            }
            else{
                if(!st1.isEmpty()){
                st1.pop();
                }
            }
        }
        
        Stack<Character>st2=new Stack<>();
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                st2.push(t.charAt(i));
            }
            else{
                if(!st2.isEmpty()){
                st2.pop();
                }
            }
        }
        
        // This is the core fix. Instead of a manual loop, we can directly
        // use the equals() method of Stack, which correctly compares
        // both the size and the content of the two stacks.
        return st1.equals(st2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("Test Case 1: s = \"ab#c\", t = \"ad#c\"");
        System.out.println("Result: " + solution.backspaceCompare("ab#c", "ad#c")); // Expected: true

        System.out.println("\nTest Case 2: s = \"a##c\", t = \"#a#c\"");
        System.out.println("Result: " + solution.backspaceCompare("a##c", "#a#c")); // Expected: true

        System.out.println("\nTest Case 3: s = \"a#c\", t = \"b\"");
        System.out.println("Result: " + solution.backspaceCompare("a#c", "b")); // Expected: false

        System.out.println("\nTest Case 4: s = \"y#fo##f\", t = \"y#f#o##f\"");
        System.out.println("Result: " + solution.backspaceCompare("y#fo##f", "y#f#o##f")); // Expected: true

        System.out.println("\nTest Case 5: s = \"ab#c\" (final: ac), t = \"ab\" (final: ab)");
        System.out.println("Result: " + solution.backspaceCompare("ab#c", "ab")); // Expected: false
    }
}
