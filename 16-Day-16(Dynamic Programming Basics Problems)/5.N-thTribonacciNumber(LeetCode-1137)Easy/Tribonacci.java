import java.util.Map;
import java.util.HashMap;

class Solution {
    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }
    
    private int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        }
        
        memo.put(n, result);
        return result;
    }
}

public class Tribonacci {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 4;
        System.out.println("The " + n1 + "th Tribonacci number is: " + solution.tribonacci(n1));
        System.out.println("---");

        // Test case 2
        int n2 = 25;
        System.out.println("The " + n2 + "th Tribonacci number is: " + solution.tribonacci(n2));
        System.out.println("---");

        // Test case 3
        int n3 = 0;
        System.out.println("The " + n3 + "th Tribonacci number is: " + solution.tribonacci(n3));
        System.out.println("---");
    }
}
