package org.vulcan.light.algorithm.lc.t40;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 * @author Sam Lu
 * @date 2022/06/10
 */
public class TrappingRainWater {

    /**
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, sum = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] <= height[right]) {
                sum += leftMax - height[left++];
            } else {
                sum += rightMax - height[right--];
            }
        }
        return sum;
    }

}
