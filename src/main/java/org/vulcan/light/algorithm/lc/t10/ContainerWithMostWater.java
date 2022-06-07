package org.vulcan.light.algorithm.lc.t10;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * @author Sam Lu
 * @date 2022/06/07
 */
public class ContainerWithMostWater {

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            if (height[left] <= height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }

}
