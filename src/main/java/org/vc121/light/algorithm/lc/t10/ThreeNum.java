package org.vc121.light.algorithm.lc.t10;

import org.vc121.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 *
 * @author Sam Lu
 * @date 2022/06/08
 */
public class ThreeNum {

    /**
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        ThreeNum threeNum = new ThreeNum();
        List<List<Integer>> result = threeNum.threeSum(nums);
        Printer.printList(result);
    }

    /**
     * 排序 + 双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复
            while (i != 0 && nums[i] == nums[i - 1] && i < nums.length - 1) i++;
            int first = nums[i], left = i + 1, right = nums.length - 1;
            while (left < right) {
                int second = nums[left], third = nums[right];
                if (first + second + third > 0) {
                    right--;
                } else if (first + second + third < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(first, second, third));
                    // 跳过重复
                    do {
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);
                    // 跳过重复
                    do {
                        right--;
                    } while (nums[right] == nums[right + 1] && left < right);
                }
            }
        }
        return result;
    }

}
