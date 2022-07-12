package org.vc121.light.algorithm.lc.t80;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 *
 * @author Sam Lu
 * @date 2022/07/01
 */
public class LargestRectangleInHistogram {

    /**
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int[] heights2 = new int[]{1};

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights2));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                right[deque.peek()] = i;
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

}
