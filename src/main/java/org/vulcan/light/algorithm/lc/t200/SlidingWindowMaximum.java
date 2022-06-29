package org.vulcan.light.algorithm.lc.t200;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/
 *
 * @author Sam Lu
 * @date 2022/06/29
 */
public class SlidingWindowMaximum {

    /**
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * // [1  3  -1] -3  5  3  6  7       3
     * //  1 [3  -1  -3] 5  3  6  7       3
     * //  1  3 [-1  -3  5] 3  6  7       5
     * //  1  3  -1 [-3  5  3] 6  7       5
     * //  1  3  -1  -3 [5  3  6] 7       6
     * //  1  3  -1  -3  5 [3  6  7]      7
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        Printer.printArray(result);
        int[] result2 = slidingWindowMaximum.maxSlidingWindow(nums2, k);
        Printer.printArray(result2);
    }

    /**
     * 单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right;
        for (int i = 0; i < nums.length; i++) {
            right = i;
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (right - left + 1 == k) {
                result[left] = nums[deque.getFirst()];
            }
            if (right - left + 1 > k) {
                left++;
                if (deque.getFirst() < left) {
                    deque.pollFirst();
                }
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }

}
