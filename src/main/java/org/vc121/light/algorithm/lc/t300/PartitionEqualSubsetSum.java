package org.vc121.light.algorithm.lc.t300;

/**
 * 416. 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 *
 * @author Sam Lu
 * @date 2022/07/28
 */
public class PartitionEqualSubsetSum {

    /**
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums2 = new int[]{2, 2, 1, 1};

        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(nums));
        System.out.println(partitionEqualSubsetSum.canPartition(nums2));
    }

    /**
     * 背包问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > target) {
                    return false;
                }
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

}
