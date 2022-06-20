package org.vulcan.light.algorithm.lc.t30;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 *
 * @author Sam Lu
 * @date 2022/06/20
 */
public class CombinationSum {

    /**
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        Printer.printList(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @param begin
     * @param result
     * @param combination
     */
    private void backtrace(int[] candidates, int target, int begin, List<List<Integer>> result, List<Integer> combination) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i, result, combination);
            combination.remove(combination.size() - 1);
        }
    }

}
