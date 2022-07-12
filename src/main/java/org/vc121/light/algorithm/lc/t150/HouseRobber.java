package org.vc121.light.algorithm.lc.t150;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 *
 * @author Sam Lu
 * @date 2022/06/11
 */
public class HouseRobber {

    /**
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{2, 1, 1, 2};

        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
        System.out.println(houseRobber.rob2(nums));
        System.out.println(houseRobber.rob(nums2));
        System.out.println(houseRobber.rob2(nums2));
    }

    /**
     * 滚动数组
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = nums[0], max2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(max1 + nums[i], max2);
            max1 = max2;
            max2 = max;
        }
        return Math.max(max1, max2);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
