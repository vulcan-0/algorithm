package org.vulcan.light.algorithm.lc.t50;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 *
 * @author Sam Lu
 * @date 2022/06/11
 */
public class JumpGame {

    /**
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i <= rightMost; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (rightMost >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
