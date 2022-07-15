package org.vc121.light.algorithm.lc.t100;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 *
 * @author Sam Lu
 * @date 2022/07/14
 */
public class LongestConsecutiveSequence {

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int right = num + 1;
                while (set.contains(right)) {
                    right++;
                }
                max = Math.max(max, right - num);
            }
        }
        return max;
    }

}
