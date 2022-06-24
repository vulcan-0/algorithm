package org.vulcan.light.algorithm.lc.t300;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public class TopKFrequentElements {

    /**
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        Printer.printArray(result);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            countMap.put(nums[i], count == null ? 1 : count + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            if (queue.size() < k) {
                queue.offer(new int[]{num, count});
            } else if (queue.peek()[1] < count) {
                queue.poll();
                queue.offer(new int[]{num, count});
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

}
