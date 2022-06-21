package org.vulcan.light.algorithm.lc.t30;

import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public class NextPermutation {

    /**
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Printer.printArray(nums);

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        Printer.printArray(nums);

        int[] nums2 = new int[]{4, 5, 2, 6, 3, 1};
        Printer.printArray(nums2);
        nextPermutation.nextPermutation(nums2);
        Printer.printArray(nums2);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        for (int i = 0; i < (nums.length - start) / 2; i++) {
            swap(nums, start + i, nums.length - i - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
