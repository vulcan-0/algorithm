package org.vc121.light.algorithm.lc.t70;

import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 *
 * @author Sam Lu
 * @date 2022/06/19
 */
public class SortColors {

    /**
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] nums2 = new int[]{1, 2, 0};
        Printer.printArray(nums);

        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        Printer.printArray(nums);

        Printer.printArray(nums2);
        sortColors.sortColors(nums2);
        Printer.printArray(nums2);
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int leftIdx = 0, rightIdx = nums.length - 1;
        for (int i = 0; i <= rightIdx; i++) {
            while (i < rightIdx && nums[i] == 2) {
                swap(nums, rightIdx, i);
                rightIdx--;
            }
            if (nums[i] == 0) {
                swap(nums, leftIdx, i);
                leftIdx++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
