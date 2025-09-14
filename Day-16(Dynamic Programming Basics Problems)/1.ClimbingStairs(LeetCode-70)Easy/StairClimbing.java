class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;        
    }
}

public class StairClimbing {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2;
        System.out.println("For n = " + n1 + ", the number of ways is: " + solution.climbStairs(n1));

        int n2 = 5;
        System.out.println("For n = " + n2 + ", the number of ways is: " + solution.climbStairs(n2));
        
        int n3 = 10;
        System.out.println("For n = " + n3 + ", the number of ways is: " + solution.climbStairs(n3));
    }
}
