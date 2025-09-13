class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] cost1 = {10, 15, 20};
        System.out.println("Cost 1: " + java.util.Arrays.toString(cost1));
        System.out.println("Minimum cost to climb stairs: " + solution.minCostClimbingStairs(cost1));
        System.out.println("---");

        // Test case 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1};
        System.out.println("Cost 2: " + java.util.Arrays.toString(cost2));
        System.out.println("Minimum cost to climb stairs: " + solution.minCostClimbingStairs(cost2));
        System.out.println("---");
    }
}
