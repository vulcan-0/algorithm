package org.vc121.light.algorithm.lc.t200;

import org.vc121.light.algorithm.lc.t100.LinkedListCycleII;

/**
 * 287. 寻找重复数
 * https://leetcode.cn/problems/find-the-duplicate-number/
 *
 * @author Sam Lu
 * @date 2022/07/07
 */
public class FindTheDuplicateNumber {

    /**
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int[] nums2 = new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1};

        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(nums));
        System.out.println(findTheDuplicateNumber.findDuplicate(nums2));
    }

    /**
     * 快慢指针，找环形链表入环点 {@link LinkedListCycleII}
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
