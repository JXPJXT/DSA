class MaxProfitSolution {
    public int maxProfit(int[] prices) {
        int val = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < val) {
                val = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - val);
            }
        }
        return maxProfit;
    }
}

class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        MaxProfitSolution solution = new MaxProfitSolution();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + solution.maxProfit(prices1));

        System.out.println("--------------------");

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input: prices = [7, 6, 4, 3, 1]");
        System.out.println("Output: " + solution.maxProfit(prices2));
    }
}