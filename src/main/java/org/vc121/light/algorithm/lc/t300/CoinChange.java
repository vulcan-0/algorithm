package org.vc121.light.algorithm.lc.t300;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public class CoinChange {

    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
