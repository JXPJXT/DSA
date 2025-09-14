class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int c : coins) {
            for (int a = c; a <= amount; a++) {
                dp[a] += dp[a - c];
            }
        }
        
        return dp[amount];        
    }
}

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int amount1 = 5;
        int[] coins1 = {1, 2, 5};
        System.out.println("Amount: " + amount1 + ", Coins: " + java.util.Arrays.toString(coins1));
        System.out.println("Number of combinations: " + solution.change(amount1, coins1));
        System.out.println("---");

        // Test case 2
        int amount2 = 3;
        int[] coins2 = {2};
        System.out.println("Amount: " + amount2 + ", Coins: " + java.util.Arrays.toString(coins2));
        System.out.println("Number of combinations: " + solution.change(amount2, coins2));
        System.out.println("---");
        
        // Test case 3
        int amount3 = 10;
        int[] coins3 = {10};
        System.out.println("Amount: " + amount3 + ", Coins: " + java.util.Arrays.toString(coins3));
        System.out.println("Number of combinations: " + solution.change(amount3, coins3));
        System.out.println("---");
    }
}
