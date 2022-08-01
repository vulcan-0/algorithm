package org.vc121.light.algorithm.lc.t300;

import org.vc121.light.algorithm.zcommon.Printer;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author Sam Lu
 * @date 2022/07/29
 */
public class FindAllNumbersDisappearedInAnArray {

    /**
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray
                = new FindAllNumbersDisappearedInAnArray();
        List<Integer> result = findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        Printer.printList(result);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
