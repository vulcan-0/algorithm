package org.vc121.light.algorithm.lc.t200;

import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/
 *
 * @author Sam Lu
 * @date 2022/07/26
 */
public class ProductOfArrayExceptSelf {

    /**
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{-1, 1, 0, -3, 3};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        int[] result2 = productOfArrayExceptSelf.productExceptSelf(nums2);
        Printer.printArray(result);
        Printer.printArray(result2);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

}
