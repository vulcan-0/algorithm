package org.vc121.light.algorithm.lc.t30;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * @author Sam Lu
 * @date 2022/06/14
 */
public class SearchInRotatedSortedArray {

    /**
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
