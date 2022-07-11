package org.vulcan.light.algorithm.lc.t70;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/
 *
 * @author Sam Lu
 * @date 2022/07/11
 */
public class EditDistance {

    /**
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1, word2));
    }

    /**
     * 动态规划
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown++;
                }
                dp[i][j] = Math.min(dp[i][j], leftDown);
            }
        }
        return dp[m][n];
    }

}
