
class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][k + 1][3];

        for (int t = 1; t <= k; t++) {
            dp[0][t][1] = -prices[0];
            dp[0][t][2] = prices[0];
        }

        for (int day = 1; day < n; day++) {
            long price = prices[day];

            for (int t = 1; t <= k; t++) {
                dp[day][t][0] = Math.max(
                    dp[day - 1][t][0],
                    Math.max(
                        dp[day - 1][t][1] + price,
                        dp[day - 1][t][2] - price
                    )
                );

                dp[day][t][1] = Math.max(
                    dp[day - 1][t][1],
                    dp[day - 1][t - 1][0] - price
                );

                dp[day][t][2] = Math.max(
                    dp[day - 1][t][2],
                    dp[day - 1][t - 1][0] + price
                );
            }
        }

        return dp[n - 1][k][0];
    }
}
