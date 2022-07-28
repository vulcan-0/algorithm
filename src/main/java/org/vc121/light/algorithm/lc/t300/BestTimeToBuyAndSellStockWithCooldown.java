package org.vc121.light.algorithm.lc.t300;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author Sam Lu
 * @date 2022/07/28
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};

        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown
                = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(bestTimeToBuyAndSellStockWithCooldown.maxProfit(prices));
    }

    /**
     * 动态规划
     * <p>
     * <li>dp[i][0] => 目前有一支股票的【累积最大收益】
     * <li>dp[i][1] => 目前没有股票，且处于冷冻期的【累积最大收益】
     * <li>dp[i][2] => 目前没有股票，且不处于冷冻期的【累积最大收益】
     * <p>
     * <li>dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i])
     * <li>dp[i][1] = dp[i - 1][0] + prices[i]
     * <li>dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2])
     * <p>
     * <li>dp[0][0] = -prices[0]
     * <li>dp[0][1] = 0
     * <li>dp[0][2] = 0
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int one = -prices[0], two = 0, three = 0;
        for (int i = 1; i < prices.length; i++) {
            int newOne = Math.max(one, three - prices[i]);
            int newTwo = one + prices[i];
            int newThree = Math.max(two, three);
            one = newOne;
            two = newTwo;
            three = newThree;
        }
        return Math.max(two, three);
    }

}
