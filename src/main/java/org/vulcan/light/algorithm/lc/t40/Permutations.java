package org.vulcan.light.algorithm.lc.t40;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/
 *
 * @author Sam Lu
 * @date 2022/06/11
 */
public class Permutations {

    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        Printer.printList(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.stream(nums).forEach(res::add);
        backtrace(result, 0, nums.length, res, new ArrayList<>());
        return result;
    }

    /**
     * 回溯算法
     *
     * @param result
     * @param index
     * @param max
     * @param res
     * @param list
     */
    private void backtrace(List<List<Integer>> result, int index, int max, List<Integer> res, List<Integer> list) {
        if (index == max) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < res.size(); i++) {
                list.add(index, res.remove(i));
                backtrace(result, index + 1, max, res, list);
                res.add(i, list.remove(index));
            }
        }
    }

}
