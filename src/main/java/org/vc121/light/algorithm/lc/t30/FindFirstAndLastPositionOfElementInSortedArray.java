package org.vc121.light.algorithm.lc.t30;

import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Sam Lu
 * @date 2022/06/07
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};

        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray =
                new FindFirstAndLastPositionOfElementInSortedArray();
        int[] result = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 8);
        Printer.printArray(result);
    }

    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);
        if (i != -1) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && nums[left] == target) left--;
            while (right < nums.length && nums[right] == target) right++;
            return new int[]{left + 1, right - 1};
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
