package org.vc121.light.algorithm.lc.t500;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 *
 * @author Sam Lu
 * @date 2022/07/29
 */
public class SubarraySumEqualsK {

    /**
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        int[] nums2 = new int[]{1, 2, 1, 2, 1};
        int k2 = 3;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
        System.out.println(subarraySumEqualsK.subarraySum(nums2, k2));
    }

    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
