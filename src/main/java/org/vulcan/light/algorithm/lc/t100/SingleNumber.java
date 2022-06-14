package org.vulcan.light.algorithm.lc.t100;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 *
 * @author Sam Lu
 * @date 2022/06/14
 */
public class SingleNumber {

    /**
     * 输入: [2,2,1]
     * 输出: 1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};

        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
