package org.vulcan.light.algorithm.lc.t150;

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 *
 * @author Sam Lu
 * @date 2022/06/13
 */
public class MajorityElement {

    /**
     * 输入：nums = [3,2,3]
     * 输出：3
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};

        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }

}
