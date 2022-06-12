package org.vulcan.light.algorithm.lc.t60;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/
 *
 * @author Sam Lu
 * @date 2022/06/12
 */
public class UniquePaths {

    /**
     * 输入：m = 3, n = 7
     * 输出：28
     *
     * @param args
     */
    public static void main(String[] args) {
        int m = 3, n = 7;

        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(m, n));
    }

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
