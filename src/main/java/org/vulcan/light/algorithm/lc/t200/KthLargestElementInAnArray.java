package org.vulcan.light.algorithm.lc.t200;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * @author Sam Lu
 * @date 2022/06/16
 */
public class KthLargestElementInAnArray {

    /**
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(nums1, k1));
        System.out.println(kthLargestElementInAnArray.findKthLargest(nums2, k2));
    }

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return search(nums, 0, nums.length - 1, k);
    }

    /**
     * 快速排序
     * // index = 4, rand = 3, pivot = 5 [0, 5]
     * // 3, 2, 1, 5, 6, 4, x = 0
     * // 3, 2, 1, 4, 6, 5, swap(rand, right)
     * // 6, 2, 1, 4, 3, 5, x = 1
     * // 6, 5, 1, 4, 3, 2, swap(x, right)
     * <p>
     * // index = 4, rand = 3, pivot = 4 [2, 5]
     * // 6, 5, 1, 4, 3, 2, x = 2
     * // 6, 5, 1, 2, 3, 4, swap(rand, right)
     * // 6, 5, 4, 2, 3, 1, swap(x, right)
     * <p>
     * // index = 4, rand = 3, pivot = 2 [3, 5]
     * // 6, 5, 4, 2, 3, 1, x = 3
     * // 6, 5, 4, 1, 3, 2, swap(rand, right)
     * // 6, 5, 4, 3, 1, 2, x = 4
     * // 6, 5, 4, 3, 2, 1, swap(x, right)
     * <p>
     * // index = 4, rand = 3, pivot = 3 [3, 3]
     * // 6, 5, 4, 3, 2, 1, x = 3
     * // 6, 5, 4, 1, 2, 3, swap(rand, right)
     * // 6, 5, 4, 3, 2, 1, swap(x, right)
     *
     * @param nums
     * @param left
     * @param right
     * @param index
     * @return
     */
    private int search(int[] nums, int left, int right, int index) {
        int rand = random.nextInt(right - left + 1) + left;
        swap(nums, rand, right);
        int x = left, pivot = nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, x++, i);
            }
        }
        swap(nums, x, right);
        if (x + 1 == index) {
            return nums[x];
        }
        return index < x + 1 ? search(nums, left, x - 1, index) : search(nums, x + 1, right, index);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
