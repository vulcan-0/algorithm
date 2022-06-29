package org.vulcan.light.algorithm.lc.t90;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/
 *
 * @author Sam Lu
 * @date 2022/06/29
 */
public class UniqueBinarySearchTrees {

    /**
     * 输入：n = 3
     * 输出：5
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(n));
    }

    /**
     * 动态规划
     * <p>
     * F(n) 表示节点为n时，二叉搜索树的总数
     * G(i,n) 表示对于节点为n的树，以第i个节点为root时，二叉搜索树的总数
     * G(i,n) = F(i-1) * F(n-i)
     * F(n) = G(1,n) + G(2,n) + ... + G(n,n)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
