package org.vulcan.light.algorithm.lc.t70;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/
 *
 * @author Sam Lu
 * @date 2022/06/19
 */
public class Subsets {

    /**
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        Printer.printList(result);
        List<List<Integer>> result2 = subsets.subsets2(nums);
        Printer.printList(result2);
        List<List<Integer>> result3 = subsets.subsets3(nums);
        Printer.printList(result3);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < 1 << n; mask++) {
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    set.add(nums[i]);
                }
            }
            result.add(set);
        }
        return result;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> set = new ArrayList<>(result.get(j));
                set.add(nums[i]);
                result.add(set);
            }
        }
        return result;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(nums, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * 回溯算法
     *
     * @param nums
     * @param start
     * @param result
     * @param set
     */
    private void backtrace(int[] nums, int start, List<List<Integer>> result, List<Integer> set) {
        result.add(new ArrayList<>(set));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtrace(nums, i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }

}
