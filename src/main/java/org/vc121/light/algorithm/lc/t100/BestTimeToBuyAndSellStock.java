package org.vc121.light.algorithm.lc.t100;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Sam Lu
 * @date 2022/6/5
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE, maxprofit = 0;
        for (int price : prices) {
            minprice = Math.min(minprice, price);
            maxprofit = Math.max(maxprofit, price - minprice);
        }
        return maxprofit;
    }

}
