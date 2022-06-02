package org.vulcan.light.algorithm.lc;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 *
 * @author Sam Lu
 * @date 2022/6/2
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = calculate(nums, target);
        Printer.printArray(result);
    }

    private static int[] calculate(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
