package org.vulcan.light.algorithm.lc.t200;

import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 *
 * @author Sam Lu
 * @date 2022/6/6
 */
public class MoveZeroes {

    /**
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        Printer.printArray(nums);
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;
        for (; first < nums.length; first++) {
            if (nums[first] != 0) {
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second++] = temp;
            }
        }
    }

}
