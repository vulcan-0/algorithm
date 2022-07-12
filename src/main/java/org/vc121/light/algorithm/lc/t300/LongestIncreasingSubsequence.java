package org.vc121.light.algorithm.lc.t300;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * @author Sam Lu
 * @date 2022/06/22
 */
public class LongestIncreasingSubsequence {

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};

        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums2));
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
